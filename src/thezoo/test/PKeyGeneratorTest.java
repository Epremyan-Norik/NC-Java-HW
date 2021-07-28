package thezoo.test;

import org.junit.Assert;
import org.junit.Test;
import thezoo.implementation.PKeyGeneratorImpl;
import thezoo.model.PKeyGenerator;

import static org.junit.Assert.*;

public class PKeyGeneratorTest {

    @Test
    public void stepIsCorrect() {
        PKeyGenerator keyGenerator = new PKeyGeneratorImpl(1,2);
        int number1 = keyGenerator.getNumber();
        int number2 = keyGenerator.getNumber();

        Assert.assertEquals(number2 - number1, 2);
    }

    @Test
    public void canGetStartValue() {
        PKeyGenerator keyGenerator = new PKeyGeneratorImpl(1,2);
        int number1 = keyGenerator.getNumber();

        Assert.assertEquals(number1, 1);
    }
}