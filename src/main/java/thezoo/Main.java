package thezoo;

import thezoo.Exceptions.ZooExceptions;
import thezoo.commandparser.*;
import thezoo.implementation.*;
import thezoo.model.*;

import java.sql.*;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws SQLException {

       Database db = new DatabaseImpl("jdbc:postgresql://localhost:5432/zooTest", "postgres", "4815");
       Zoo zoo = new ZooImpl(db);


       //инифиализация при первом запуске
       Connection cn =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/zooTest", "postgres", "4815");
       cn.setAutoCommit(false);
       Statement statement = cn.createStatement();
       ResultSet resultSet =  statement.executeQuery("SELECT * FROM cages");
       if(!resultSet.next()){
           statement.executeUpdate(String.format("INSERT INTO cages(area, availablefor) VALUES(%d, %d);", 200, 1));
           statement.executeUpdate(String.format("INSERT INTO cages(area, availablefor) VALUES(%d, %d);", 200, 2));
           statement.executeUpdate(String.format("INSERT INTO cages(area, availablefor) VALUES(%d, %d);", 200, 3));
           statement.executeUpdate(String.format("INSERT INTO cages(area, availablefor) VALUES(%d, %d);", 200, 4));
       }
       cn.commit();
       cn.close();

       while (runCommandsFromConsole(zoo));


    }

    public static boolean runCommandsFromConsole(Zoo zoo){
        printCommandList();
        String[] commands  = new Parser().getCommand();
        commands[0]= commands[0].toLowerCase(Locale.ROOT);

        String[] nextCommand = new String[commands.length - 1];
        if (commands.length>1){
            for (int i = 0; i < commands.length - 1; i++) {
                nextCommand[i] = commands[i + 1];
            }
        }


        switch (commands[0]) {
            case ("check-in"): {
                CommandFactory checkIn = new CheckInImpl();
                try {
                    checkIn.runCommand(nextCommand, zoo);
                }
                catch (CheckInImpl.InputIsNotValid exc){
                    exc.printStackTrace();
                }
                break;
            }
            case ("check-out"): {
                CommandFactory checkOut = new CheckOutImpl();
                try {
                    checkOut.runCommand(nextCommand, zoo);
                }
                catch (CheckInImpl.InputIsNotValid exc){
                    exc.printStackTrace();
                }
                break;
            }
            case ("log"): {
                CommandFactory log = new PrintLog();
                try {
                    log.runCommand(nextCommand, zoo);
                }
                catch (CheckInImpl.InputIsNotValid exc){
                    exc.printStackTrace();
                }
                break;
            }
            case ("exit"): {
                return false;
            }
            default: {
                System.out.println("Unknown Command");
            }
        }

        return true;
    };

    public static void printCommandList(){
        System.out.println("Commands :" + "\n"
                + "- check-in" + "\n"
                + "- check-out" + "\n"
                + "- log" + "\n"
                + "- Exit");
    }
}
