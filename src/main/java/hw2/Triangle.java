package hw2;

public class Triangle implements shape {
    double a;
    double b;
    double c;

    public Triangle(){
        a = 0;
        b = 0;
        c = 0;
    }

    public Triangle(double _a, double _b, double _c){
        if ((_a + _b < _c) || (_a + _c < _b) || (_b + _c < _a)) {
            a = 0;
            b = 0;
            c = 0;
        } else if ((_a >= 0) && (_b >= 0) && (_c >= 0)) {
                    a = _a;
                    b = _b;
                    c = _c;
                } else  {
                a = 0;
                b = 0;
                c = 0;
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

    public void setC(double _c) {
        if (_c >= 0) {
            c = _c;
        }
        else {
            c = 0;
        }
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }

    @Override
    public double getArea() {
        double halfPerimeter = (a+b+c)/2;
        return Math.sqrt(halfPerimeter*(halfPerimeter-a)*(halfPerimeter-b)*(halfPerimeter-c));
    }
}
