package thezoo.test;

import org.junit.Test;
import thezoo.Zoo;
import thezoo.ZooImpl;
import thezoo.implementation.DatabaseImpl;
import thezoo.implementation.СonditionImpl;
import thezoo.model.Database;
import thezoo.model.Species;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class ZooTest {

    @Test
    public void checkInAnimal() {
        Database db;
        try{
            db = new DatabaseImpl("jdbc:postgresql://localhost:5432/zoo", "postgres", "4815");
            Zoo zoo = new ZooImpl(db);
            zoo.putCage(200, new СonditionImpl(Species.LEON));
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }

}