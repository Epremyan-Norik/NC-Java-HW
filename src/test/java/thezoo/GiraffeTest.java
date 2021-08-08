package thezoo;

import org.junit.Assert;
import org.junit.Test;
import thezoo.implementation.Giraffe;
import thezoo.model.Species;

import static org.junit.Assert.*;

public class GiraffeTest {


    @Test
    public void getName() {
        Giraffe gira = new Giraffe("Gira", Species.GIRAFFE);

        String name = gira.getName();

        Assert.assertEquals(name, "Gira");
    }

    @Test
    public void getSpecies() {
        Giraffe gira = new Giraffe("Gira", Species.GIRAFFE);

        Species species = gira.getSpecies();

        Assert.assertEquals(species, Species.GIRAFFE);
    }
}