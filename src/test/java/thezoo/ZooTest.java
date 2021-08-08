package thezoo;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import thezoo.Exceptions.ZooExceptions;
import thezoo.implementation.AnimalImpl;
import thezoo.implementation.СonditionImpl;
import thezoo.model.Animal;
import thezoo.model.Species;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ZooTest {

    @Test
    public void checkInAnimal() {
        boolean result = false;
        Zoo zoo = new ZooImpl();
        zoo.putCage(200, new СonditionImpl(Species.LEON));
        try {
            zoo.checkInAnimal(new AnimalImpl("Leo", Species.LEON));
            List<InhibitionLog> history = zoo.getHistory();
            int index1 = history.get(0).toString().lastIndexOf("animalSpecies=LEON");
            int index2 = history.get(0).toString().lastIndexOf("animalName=\'Leo\'");
            if(index1>0 && index2>0){
                result = true;
            }
        } catch (ZooExceptions.CageNotFound e){
            e.printStackTrace();
            result = false;
        } catch (ZooExceptions.IncorrectName e){
            e.printStackTrace();
            result = false;
        }
        Assert.assertTrue(result);

    }

    @Test
    public void checkOutAnimal() {
        boolean result = false;
        Zoo zoo = new ZooImpl();
        zoo.putCage(200, new СonditionImpl(Species.LEON));
        try {
            zoo.checkInAnimal(new AnimalImpl("Leo", Species.LEON));
            zoo.checkOutAnimal("Leo");
            List<InhibitionLog> history = zoo.getHistory();
            int index1 = history.get(1).toString().lastIndexOf("animalSpecies=LEON");
            int index2 = history.get(1).toString().lastIndexOf("animalName=\'Leo\'");
            if(index1>0 && index2>0){
                result = true;
            }
        } catch (ZooExceptions.CageNotFound e){
            e.printStackTrace();
            result = false;
        } catch (ZooExceptions.IncorrectName e){
            e.printStackTrace();
            result = false;
        }
        Assert.assertTrue(result);
    }



    @Test(expected = ZooExceptions.CageNotFound.class)
    public void cageNotFoundException() throws ZooExceptions.CageNotFound, ZooExceptions.IncorrectName {
        boolean result = true;
        Zoo zoo = new ZooImpl();
        zoo.checkInAnimal(new AnimalImpl("Leo", Species.LEON));
    }
}