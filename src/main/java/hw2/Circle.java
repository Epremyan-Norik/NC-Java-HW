package hw2;

public class Circle implements shape {
    double radius;

    public Circle(){
        radius = 0;
    }

    public Circle(double _radius){
        if (_radius >= 0) {
            radius = _radius;
        }
        else {
            radius = 0;
        }
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double _radius) {
        if (_radius >= 0) {
            radius = _radius;
        }
        else {
            radius = 0;
        }
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }

    @Override
    public double getArea() {
        return Math.PI*radius*radius;
    }
}
