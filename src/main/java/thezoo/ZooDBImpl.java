package thezoo;

import thezoo.Exceptions.ZooExceptions;
import thezoo.implementation.CageImpl;
import thezoo.implementation.PKeyGeneratorImpl;
import thezoo.model.*;

import java.io.IOException;
import java.util.*;

public class ZooDBImpl implements Zoo{
    Database dbConnection;


    public ZooDBImpl(Database dbConnection){
        this.dbConnection = dbConnection;
    }

    @Override
    public void checkInAnimal(Animal animal) throws ZooExceptions.IncorrectName, ZooExceptions.CageNotFound {
        dbConnection.checkIn(animal);
    }

    @Override
    public void checkOutAnimal(String name) throws ZooExceptions.IncorrectName {
        dbConnection.checkOut(name);
    }

    @Override
    public List<InhibitionLog> getHistory() {
        return dbConnection.getHistory();
    }

    @Override
    public void putCage(double area, Condition condition) {
        dbConnection.putCage(area, condition);
    }

    @Override
    public void removeCage(int number) throws ZooExceptions.CageNotEmpty {
        dbConnection.removeCage(number);
    }

}
