package thezoo.test;

import org.junit.Assert;
import org.junit.Test;
import thezoo.implementation.AnimalBuilder;
import thezoo.model.Animal;
import thezoo.model.Builder;
import thezoo.model.Species;

import static org.junit.Assert.*;

public class AnimalBuilderTest {

    @Test
    public void canCreateCorrectAnimal() {
        AnimalBuilder builder = new AnimalBuilder();

        builder.setSpecies(Species.LEON);
        builder.setName("Leo");
        Animal animal = builder.getResult();

        Assert.assertTrue(animal.getName().equals("Leo")&&animal.getSpecies().equals(Species.LEON));
    }
}