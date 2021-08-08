package thezoo.implementation;

import thezoo.model.Cage;
import thezoo.model.Condition;
import thezoo.model.PKeyGenerator;

public class CageImpl implements Cage {

    private double area = 0;
    private int key;
    private boolean isVacant;
    private Condition availableFor;
    private String name;


    public CageImpl(PKeyGenerator pKeyGenerator, double area, Condition condition){
       this.key = pKeyGenerator.getNumber();
       this.area = area;
       this.isVacant = true;
       this.availableFor = condition;
    }

    @Override
    public int getNumber() {

        return key;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public Condition getCondition() {
        return availableFor;
    }

    @Override
    public boolean isVacantCage() {
        return isVacant;
    }

    @Override
    public void reserveCage(String name) {
        if(isVacant) {
            isVacant = false;
            this.name = name;
        }
    }

    @Override
    public void releaseCage(){
        this.name = null;
        isVacant = true;
    }

    @Override
    public String getName() {
        return name;
    }
}
