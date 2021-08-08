package thezoo;

import org.junit.Assert;
import org.junit.Test;
import thezoo.implementation.Giraffe;
import thezoo.implementation.Leon;
import thezoo.model.Species;

import static org.junit.Assert.*;

public class LeonTest {

    @Test
    public void getName() {
        Leon leo = new Leon("Leo", Species.LEON);

        String name = leo.getName();

        Assert.assertEquals(name, "Leo");
    }

    @Test
    public void getSpecies() {
        Leon leo = new Leon("Leo", Species.LEON);

        Species species = leo.getSpecies();

        Assert.assertEquals(species, Species.LEON);
    }
}