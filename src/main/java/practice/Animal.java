package practice;



public abstract class Animal {
    Point position;

    void move(Point point){
        position = point;
        System.out.format("%s move to (%s, %s)", this.getClass().getName(),point.getX(), point.getY());
        System.out.println();
    };

    abstract boolean eat(Animal animal);

}
