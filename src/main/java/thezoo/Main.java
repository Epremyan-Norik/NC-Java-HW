package thezoo;

import thezoo.Exceptions.ZooExceptions;
import thezoo.commandparser.*;
import thezoo.implementation.*;
import thezoo.model.*;

import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class Main {
    public static void main(String[] args) throws SQLException {

       Database db = new DatabaseImpl("jdbc:postgresql://localhost:5432/zooTest", "postgres", "4815");
       Zoo zoo = new ZooDBImpl(db);


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

       while (printCommandList() && CommandRunner.runCommandsFromConsole(zoo));


    }
    public static boolean printCommandList(){
        System.out.println("Commands :" + "\n"
                + "- check-in" + "\n"
                + "- check-out" + "\n"
                + "- log" + "\n"
                + "- Exit");
        return true;
    }
}
