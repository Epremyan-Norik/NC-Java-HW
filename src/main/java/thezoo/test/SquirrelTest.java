package thezoo.test;

import org.junit.Assert;
import org.junit.Test;
import thezoo.implementation.Penguin;
import thezoo.implementation.Squirrel;
import thezoo.model.Species;

import static org.junit.Assert.*;

public class SquirrelTest {

    @Test
    public void getName() {
        Squirrel squir = new Squirrel("Squir", Species.SQUIRREL);

        String name = squir.getName();

        Assert.assertEquals(name, "Squir");
    }

    @Test
    public void getSpecies() {
        Squirrel squir = new Squirrel("Squir", Species.SQUIRREL);

        Species species = squir.getSpecies();

        Assert.assertEquals(species, Species.SQUIRREL);
    }
}