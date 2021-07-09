package hw2;

public class MainClass {
    public static void main(String[] args) {
        Box box = new Box(5);
        Triangle triangle = new Triangle(4,5,6);
        Circle circle = new Circle(5);
        Ellipse ellipse = new Ellipse(3,4);

        System.out.println(box.toString());
        System.out.format("Area: %s ", box.getArea());
        System.out.println();

        System.out.println(triangle.toString());
        System.out.format("Area: %s ", triangle.getArea());
        System.out.println();

        System.out.println(circle.toString());
        System.out.format("Area: %s ", circle.getArea());
        System.out.println();

        System.out.println(ellipse.toString());
        System.out.format("Area: %s ", ellipse.getArea());
        System.out.println();
    }
}
