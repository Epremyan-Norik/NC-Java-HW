package hw2;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EllipseTest {

    @Test
    public void canCreateEllipse() {
        Ellipse ellipse1 = new Ellipse();
        double eps = 0.00001;

        Assert.assertTrue((Math.abs(ellipse1.getA() - 0 ) < eps) && (Math.abs(ellipse1.getB() - 0) < eps));
    }

    @Test
    public void canCreateEllipseWithArgs() {
        double a = 2;
        double b = 3;
        Ellipse ellipse1 = new Ellipse(a,b);
        double eps = 0.00001;

        Assert.assertTrue((Math.abs(ellipse1.getA() - a) < eps)&&(Math.abs(ellipse1.getB() - b) < eps));
    }

    @Test
    public void canSetAndGetA() {
        double a = 2;
        Ellipse ellipse1 = new Ellipse();
        double eps = 0.00001;

        ellipse1.setA(a);

        Assert.assertTrue((Math.abs(ellipse1.getA() - a) < eps));
    }

    @Test
    public void canSetAndGetB() {
        double b = 3;
        Ellipse ellipse1 = new Ellipse();
        double eps = 0.00001;

        ellipse1.setB(b);

        Assert.assertTrue((Math.abs(ellipse1.getB() - b) < eps));
    }

    @Test
    public void canGetTrueArea() {
        double a = 2;
        double b = 3;
        Ellipse ellipse1 = new Ellipse(a,b);
        double eps = 0.00001;

        Assert.assertTrue((Math.abs(ellipse1.getArea() - Math.PI * a * b) < eps));
    }

    @Test
    public void canGetAreaWithNegative() {
        double a = -2;
        double b = 3;
        Ellipse ellipse1 = new Ellipse(a,b);
        double eps = 0.00001;

        Assert.assertTrue((Math.abs(ellipse1.getArea() - 0) < eps));
    }
}