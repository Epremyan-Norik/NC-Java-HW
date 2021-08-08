package thezoo.test;

import org.junit.Assert;
import org.junit.Test;
import thezoo.implementation.CageImpl;
import thezoo.implementation.PKeyGeneratorImpl;
import thezoo.implementation.СonditionImpl;
import thezoo.model.Cage;
import thezoo.model.Condition;
import thezoo.model.PKeyGenerator;
import thezoo.model.Species;

import java.util.List;

import static org.junit.Assert.*;

public class CageTest {

    @Test
    public void getNumber() {
        PKeyGenerator keyGenerator = new PKeyGeneratorImpl(1,1);

        Cage cage = new CageImpl(keyGenerator,200, new СonditionImpl(Species.LEON));
        int number = cage.getNumber();

        Assert.assertEquals(1, number);
    }

    @Test
    public void getArea() {
        PKeyGenerator keyGenerator = new PKeyGeneratorImpl(1,1);

        Cage cage = new CageImpl(keyGenerator,200, new СonditionImpl(Species.LEON));
        double area = cage.getNumber();

        Assert.assertTrue((area-200)<Math.ulp(1.0));
    }

    @Test
    public void getCondition() {
        PKeyGenerator keyGenerator = new PKeyGeneratorImpl(1,1);

        Cage cage = new CageImpl(keyGenerator,200, new СonditionImpl(Species.LEON));
        List<Species> condition = cage.getCondition().isAvailableFor();

        Assert.assertEquals(condition.get(0),Species.LEON);

    }

    @Test
    public void isVacantCageReturnFalse() {
        PKeyGenerator keyGenerator = new PKeyGeneratorImpl(1,1);

        Cage cage = new CageImpl(keyGenerator,200, new СonditionImpl(Species.LEON));
        cage.reserveCage("Leo");

        Assert.assertFalse(cage.isVacantCage());
    }

    @Test
    public void isVacantCageReturnTrue() {
        PKeyGenerator keyGenerator = new PKeyGeneratorImpl(1,1);

        Cage cage = new CageImpl(keyGenerator,200, new СonditionImpl(Species.LEON));

        Assert.assertTrue(cage.isVacantCage());
    }


    @Test
    public void getName() {
        PKeyGenerator keyGenerator = new PKeyGeneratorImpl(1,1);

        Cage cage = new CageImpl(keyGenerator,200, new СonditionImpl(Species.LEON));
        cage.reserveCage("Leo");

        Assert.assertEquals("Leo", cage.getName());
    }

    @Test
    public void getNameNull() {
        PKeyGenerator keyGenerator = new PKeyGeneratorImpl(1,1);

        Cage cage = new CageImpl(keyGenerator,200, new СonditionImpl(Species.LEON));

        Assert.assertNull(cage.getName());
    }

    @Test
    public void cantReserveCageWithAnimal() {
        PKeyGenerator keyGenerator = new PKeyGeneratorImpl(1,1);

        Cage cage = new CageImpl(keyGenerator,200, new СonditionImpl(Species.LEON));
        cage.reserveCage("Leo");
        cage.reserveCage("Simba");

        Assert.assertEquals("Leo", cage.getName());
    }
}