package hw2;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {

    @Test
    public void canCreateTriangle() {
        Triangle triangle1 = new Triangle();
        double eps = 0.00001;

        Assert.assertTrue(Math.abs(triangle1.getA() - 0) < eps);
    }

    @Test
    public void canCreateTriangleWithArgs() {
        double a = 3;
        double b = 4;
        double c = 5;
        Triangle triangle1 = new Triangle(a,b,c);
        double eps = 0.00001;

        Assert.assertTrue((Math.abs(triangle1.getA() - a) < eps) && (Math.abs(triangle1.getB() - b) < eps) && (Math.abs(triangle1.getC() - c) < eps));
    }

    @Test
    public void canSetAndGetA() {
        double a = 1;
        Triangle triangle1 = new Triangle();
        double eps = 0.00001;

        triangle1.setA(a);

        Assert.assertTrue(Math.abs(triangle1.getA() - a) < eps);
    }

    @Test
    public void canSetAndGetB() {
        double b = 1;
        Triangle triangle1 = new Triangle();
        double eps = 0.00001;

        triangle1.setB(b);

        Assert.assertTrue(Math.abs(triangle1.getB() - b) < eps);
    }

    @Test
    public void canSetAndGetC() {
        double c = 1;
        Triangle triangle1 = new Triangle();
        double eps = 0.00001;

        triangle1.setC(c);

        Assert.assertTrue(Math.abs(triangle1.getC() - c) < eps);
    }

    @Test
    public void canGetTrueArea() {
        double a = 3;
        double b = 4;
        double c = 5;
        double eps = 0.00001;

        Triangle triangle1 = new Triangle(a,b,c);

        Assert.assertTrue((Math.abs(triangle1.getArea() - 6 ) < eps));
    }

    @Test
    public void canGetAreaWithNegativeArgs() {
        double a = 3;
        double b = -4;
        double c = 5;
        double eps = 0.00001;

        Triangle triangle1 = new Triangle(a,b,c);

        Assert.assertTrue((Math.abs(triangle1.getArea() - 0) < eps));

    }

    @Test
    public void canGetAreaOfUnrealTriangle() {
        double a = 1;
        double b = 2;
        double c = 4;
        double eps = 0.00001;

        Triangle triangle1 = new Triangle(a,b,c);

        Assert.assertTrue((Math.abs(triangle1.getArea() - 0) < eps));

    }
}