package practice;

public class Jerry extends Animal{
    //Point position;

    /*@Override
    public void move(Point point) {
        position = point;
        System.out.format("Jerry move to (%s, %s)", point.getX(), point.getY());
        System.out.println();
    }*/

    @Override
    public boolean eat(Animal animal) {
        return false;
    }
}
