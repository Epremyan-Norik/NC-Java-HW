package thezoo;

import org.junit.Assert;
import org.junit.Test;
import thezoo.implementation.Giraffe;
import thezoo.implementation.Leon;
import thezoo.implementation.Penguin;
import thezoo.model.Species;

import static org.junit.Assert.*;

public class PenguinTest {

    @Test
    public void getName() {
        Penguin pen = new Penguin("Pen", Species.PENGUIN);

        String name = pen.getName();

        Assert.assertEquals(name, "Pen");
    }

    @Test
    public void getSpecies() {
        Penguin pen = new Penguin("Pen", Species.PENGUIN);

        Species species = pen.getSpecies();

        Assert.assertEquals(species, Species.PENGUIN);
    }
}