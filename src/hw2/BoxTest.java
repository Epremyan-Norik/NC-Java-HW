package hw2;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoxTest {

    @Test
    public void canCrateBox() {
        Box box1 = new Box();
        double eps = 0.00001;

        Assert.assertTrue(Math.abs(box1.getA()-0)<eps);
    }

    @Test
    public void canCreateBoxWithArgs() {
        double a = 4;
        Box box1 = new Box(a);
        double eps = 0.00001;

        Assert.assertTrue(Math.abs(box1.getA()-a)<eps);
    }

    @Test
    public void canGetA() {
        double a = 4;
        Box box1 = new Box(a);
        double eps = 0.00001;

        Assert.assertTrue(Math.abs(box1.getA()-a)<eps);
    }

    @Test
    public void canSetA() {
        double a = 4;
        Box box1 = new Box();
        double eps = 0.00001;

        box1.setA(a);

        Assert.assertTrue(Math.abs(box1.getA()-a)<eps);
    }


    @Test
    public void canGetTrueArea() {
        double a = 4;
        Box box1 = new Box();
        double eps = 0.00001;

        box1.setA(a);

        Assert.assertTrue(Math.abs(box1.getArea()-a*a)<eps);
    }

    @Test
    public void canGetAreaWithNegativeArgs() {
        double a = -4;
        Box box1 = new Box();
        double eps = 0.00001;

        box1.setA(a);

        Assert.assertTrue(Math.abs(box1.getArea()-0)<eps);
    }
}