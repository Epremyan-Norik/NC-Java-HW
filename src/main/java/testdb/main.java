package testdb;

import java.sql.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class main {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/practice", "postgres", "4815");
        Statement statement = connection.createStatement();
        connection.setAutoCommit(false);

        for(int i = 0; i<10; i++){
            int value = i*i+i;
            NumberFormat formatter = new DecimalFormat("#0,00");
            statement.executeUpdate(String.format("insert into func(x,y) values(%d, %d) on conflict(x) do UPDATE SET y = %d;" ,
                    i, value, value) );
        }
        connection.commit();


        ResultSet resultSet = statement.executeQuery("select * from func");
        while(resultSet.next()) {
            System.out.println(resultSet.getDouble("x") + " " + resultSet.getDouble("y") );
        }
    }
}
