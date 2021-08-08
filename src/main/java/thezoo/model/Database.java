package thezoo.model;

import thezoo.Exceptions.ZooExceptions;
import thezoo.InhibitionLog;
import thezoo.ZooImpl;
import thezoo.implementation.DatabaseImpl;

import java.sql.SQLException;
import java.util.List;

public interface Database {
    void checkIn(Animal animal) throws ZooExceptions.CageNotFound, ZooExceptions.IncorrectName;
    void checkOut(String name) throws ZooExceptions.IncorrectName;
    void putCage(double area, Condition condition);
    void removeCage(int cage_id) throws ZooExceptions.CageNotEmpty;
    List<InhibitionLog> getHistory();
}
