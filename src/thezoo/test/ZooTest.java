package thezoo.test;

import org.junit.Test;
import thezoo.Zoo;
import thezoo.ZooImpl;
import thezoo.implementation.СonditionImpl;
import thezoo.model.Species;

import static org.junit.Assert.*;

public class ZooTest {

    @Test
    public void checkInAnimal() {
        Zoo zoo = new ZooImpl();
        zoo.putCage(200, new СonditionImpl(Species.LEON));

    }

    @Test
    public void checkOutAnimal() {
        Zoo zoo = new ZooImpl();
    }

    @Test
    public void getHistory() {
        Zoo zoo = new ZooImpl();
    }

    @Test
    public void putCage() {
        Zoo zoo = new ZooImpl();
    }

    @Test
    public void removeCage() {
        Zoo zoo = new ZooImpl();
    }
}