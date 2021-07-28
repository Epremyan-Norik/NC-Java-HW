package thezoo.implementation;

import thezoo.model.PKeyGenerator;

import static java.lang.Math.abs;

public class PKeyGeneratorImpl implements PKeyGenerator {

    private int value;
    private int step;

    public PKeyGeneratorImpl(int startValue, int step){
        this.value = startValue;
        this.step = abs(step);
    }

    @Override
    public int getNumber() {
        int returnNumber = value;
        value += step;
        return returnNumber;
    }
}
