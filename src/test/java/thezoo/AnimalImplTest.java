package thezoo;

import org.junit.Assert;
import org.junit.Test;
import thezoo.implementation.AnimalImpl;
import thezoo.model.Species;

import static org.junit.Assert.*;

public class AnimalImplTest {

    @Test
    public void getName() {
        AnimalImpl animal = new AnimalImpl("Leo", Species.LEON);

        String name = animal.getName();

        Assert.assertEquals(name, "Leo");
    }

    @Test
    public void getSpecies() {
        AnimalImpl animal = new AnimalImpl("Leo", Species.LEON);

        Species species = animal.getSpecies();

        Assert.assertEquals(species, Species.LEON);
    }
}