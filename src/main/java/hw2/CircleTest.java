package hw2;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CircleTest {

    @Test
    public void canCreateCircle() {
        Circle circle1 = new Circle();
        double eps = 0.00001;

        Assert.assertTrue(Math.abs(circle1.getRadius() - 0) < eps);
    }

    @Test
    public void canCreateCircleWithArgs() {
        double radius = 3.5;
        double eps = 0.00001;

        Circle circle1 = new Circle(radius);

        Assert.assertTrue(Math.abs(circle1.getRadius() - radius) < eps);
    }

    @Test
    public void canGetAndSetRadius() {
        double radius = 5.5;
        double eps = 0.00001;
        Circle circle1 = new Circle();

        circle1.setRadius(radius);

        Assert.assertTrue(Math.abs(circle1.getRadius() - radius) < eps);
    }

    @Test
    public void canGetTrueArea() {
        double radius = 5.5;
        double eps = 0.00001;
        Circle circle1 = new Circle();

        circle1.setRadius(radius);

        Assert.assertTrue(Math.abs(circle1.getArea()-Math.PI * radius * radius) < eps);
    }

    @Test
    public void canGetAreaWithNegative() {
        double radius = -10;
        double eps = 0.00001;
        Circle circle1 = new Circle();

        circle1.setRadius(radius);

        Assert.assertTrue(Math.abs(circle1.getArea() - 0) < eps);
    }
}