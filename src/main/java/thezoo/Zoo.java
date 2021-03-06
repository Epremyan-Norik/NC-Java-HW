package thezoo;

import thezoo.Exceptions.ZooExceptions;
import thezoo.model.Animal;
import thezoo.model.Condition;

import java.util.List;

/**
 * entity keep state of Zoo and provide service desk functionality
 * @checkInAnimal method add Animal to Zoo
 * should throw exception when Zoo can't provide place
 * @checkOutAnimal method remove Animal from Zoo
 * @getHistory - method show log of check in and check out
 */
public interface Zoo {
    void checkInAnimal(Animal animal) throws ZooExceptions.IncorrectName, ZooExceptions.CageNotFound;
    void checkOutAnimal(String name) throws ZooExceptions.IncorrectName;
    List<InhibitionLog> getHistory();
    void putCage(double area, Condition condition);
    void removeCage(int number) throws ZooExceptions.CageNotEmpty;
}