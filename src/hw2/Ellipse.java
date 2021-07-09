package hw2;

public class Ellipse implements shape{
    double a;
    double b;

    public Ellipse(){
        a = 0;
        b = 0;
    }

    public Ellipse(double _a, double _b){
        if((_a >= 0) && (_b >= 0)){
            a = _a;
            b = _b;
        } else {
            a = 0;
            b = 0;
        }
    }

    public void setA(double _a) {
        if (_a >= 0) {
            a = _a;
        }
        else {
            a = 0;
        }
    }

    public void setB(double _b) {
        if (_b >= 0) {
            b = _b;
        }
        else {
            b = 0;
        }
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    @Override
    public String toString() {
        return "Ellipse{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    @Override
    public double getArea() {
        return Math.PI*a*b;
    }
}
