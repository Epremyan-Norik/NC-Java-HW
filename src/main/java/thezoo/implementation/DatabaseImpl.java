package thezoo.implementation;

import thezoo.Exceptions.ZooExceptions;
import thezoo.InhibitionLog;
import thezoo.ZooImpl;
import thezoo.model.Animal;
import thezoo.model.Condition;
import thezoo.model.Database;
import thezoo.model.Species;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class DatabaseImpl implements Database {
    private Connection connection;
    private String db;
    private String user;
    private String pass;

    public DatabaseImpl(String db, String user, String pass) throws SQLException {
        connection = DriverManager.getConnection(db, user, pass);
        connection.setAutoCommit(false);
    }

    @Override
    public void checkIn(Animal animal) throws ZooExceptions.CageNotFound, ZooExceptions.IncorrectName {

        try {

            Statement statement = connection.createStatement();
            ResultSet freeCagesId = statement.executeQuery(String.format("SELECT cage_id FROM cages " +
                    "WHERE cage_id NOT IN (SELECT cage_id FROM animals)" +
                    " AND availablefor = (SELECT sp_id FROM species WHERE sp_name =\'%s\');", animal.getSpecies()));

            if (!freeCagesId.next()) throw new ZooExceptions.CageNotFound("Cage Not Found");
            ResultSet nameNotExist = statement.executeQuery(String.format("SELECT name FROM animals WHERE name = \'%s\';", animal.getName()));
            //connection.commit();

            if (nameNotExist.next()) throw new ZooExceptions.IncorrectName("Name Already Exist");
            ResultSet speciesId = statement.executeQuery(String.format("SELECT sp_id FROM species WHERE sp_name = \'%s\';", animal.getSpecies()));
            int updateRes = 0;
            if (speciesId.next()) {

                updateRes = statement.executeUpdate(String.format("INSERT INTO animals VALUES(\'%s\', %d, %d);",
                        animal.getName(),
                        speciesId.getInt("sp_id"),
                        freeCagesId.getInt("cage_id")));
            }

            if (updateRes == 0) {
                System.out.println("Rollback");
                connection.rollback();
            } else {
                statement.executeUpdate(String.format("INSERT INTO logs(checkin, species, name) VALUES(current_date, \'%s\', \'%s\')",  animal.getSpecies(), animal.getName()));
                System.out.println("Commit");
                connection.commit();
            }


        } catch (SQLException e){
            e.printStackTrace();
        }


    }

    @Override
    public void checkOut(String name) throws ZooExceptions.IncorrectName {
        try {
            Statement statement = connection.createStatement();
            ResultSet animal = statement.executeQuery(String.format("SELECT name, sp_name FROM animals, species" +
                                    " WHERE name = \'%s\' AND sp_id = species_id;", name));

            if (!animal.next()) throw new ZooExceptions.IncorrectName(String.format("Name %s not found in DB", name));
            int updateRes = statement.executeUpdate(String.format("DELETE FROM animals WHERE name = \'%s\';", name));

            if (updateRes == 0) {
                System.out.println("Rollback");
                connection.rollback();
            } else {
                statement.executeUpdate(String.format("INSERT INTO logs(checkout, species, name) VALUES(current_date, \'%s\', \'%s\')",
                        animal.getString("sp_name"), animal.getString("name")));
                System.out.println("Commit");
                connection.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void putCage(double area, Condition condition) {
        try {
            String sqlCmd = "INSERT INTO cages(area, availablefor) VALUES(?, ?);";
            Statement statement = connection.createStatement();
            ResultSet strSpecies = statement.executeQuery(String.format("SELECT sp_id FROM species WHERE sp_name = \'%s\'", condition.isAvailableFor().get(0).toString()));
            if(!strSpecies.next()) throw new ZooExceptions.CageNotFound("Species is incorrect");
            PreparedStatement prStatement = connection.prepareStatement(sqlCmd);
            prStatement.setDouble(1, area);
            prStatement.setInt(2, strSpecies.getInt(1));
            prStatement.executeUpdate();
            connection.commit();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        catch (ZooExceptions.CageNotFound e){
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void removeCage(int cage_id) throws  ZooExceptions.CageNotEmpty {
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(String.format("SELECT name FROM animals WHERE cage_id = %d", cage_id));
            if (result.next()) throw new ZooExceptions.CageNotEmpty(String.format("In cage live animal: %s", result.getString("name")));
            int success = statement.executeUpdate(String.format("DELETE FROM cages WHERE cage_id = %d", cage_id));
            if(success == 0) throw new ZooExceptions.CageNotFound(String.format("Cage number %d not found", cage_id));
            connection.commit();
        }
        catch (SQLException  e){
            e.printStackTrace();
        }
        catch (ZooExceptions.CageNotFound e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<InhibitionLog> getHistory() {
        List<InhibitionLog> history = new LinkedList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT checkin, checkout, species, name FROM logs ORDER BY log_id");
            while (result.next()){
                String spStr = result.getString(3).toUpperCase(Locale.ROOT);
                for(Species sp : Species.values()){
                    if(sp.toString().equals(spStr)) {
                        history.add(new InhibitionLog(
                                result.getDate(1),
                                result.getDate(2),
                                sp,
                                result.getString(4)
                        ));
                    }
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return history;
    }

}
