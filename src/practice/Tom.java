package practice;

public class Tom extends Animal{

    //Point position;

    /*@Override
    public void move(Point point) {
        position = point;
        System.out.format("Jerry move to (%s, %s)", point.getX(), point.getY());
        System.out.println();
    }*/

    @Override
    public boolean eat(Animal animal) {
        if (animal.getClass().getName().equals("practice.Jerry")) {
            System.out.format("Tom eat Jerry");
            System.out.println();
            return true;
        } else{
            return false;
        }
    }
}
