package hw2;

public class Box implements hw2.shape {
    double a;

    public Box(){
        a = 0;
    }

    public  Box(double _a){
        if (_a >= 0) {
            a = _a;
        }
        else {
            a = 0;
        }
    }

    public double getA() {
        return a;
    }

    public void setA(double _a) {
        if (_a >= 0) {
            a = _a;
        }
        else {
            a = 0;
        }
    }

    @Override
    public String toString() {
        return "Box{" +
                "a=" + a +
                '}';
    }

    @Override
    public double getArea() {
        return a*a;
    }
}
