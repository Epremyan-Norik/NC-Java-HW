package thezoo.model;

/**
 * class provide information about Cage
 * Assumptions:
 * one Cage - one Animal
 * @getNumber() used as return primary key
 */
public interface Cage {
    //primary key
    int getNumber();
    double getArea();
    Condition getCondition();
    boolean isVacantCage();
    void reserveCage(String name);
    void releaseCage();
    String getName();
}
