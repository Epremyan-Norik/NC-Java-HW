package practice;

public class Spike extends Animal {
   // Point position;
   /* @Override
    public void move(Point point) {
        position = point;
        System.out.format("Jerry move to (%s, %s)", point.getX(), point.getY());
        System.out.println();
    }*/

    @Override
    public boolean eat(Animal animal) {
        if (animal.getClass().getName().equals("practice.Jerry")) {
            System.out.format("Spike eat Jerry");
            System.out.println();
            return true;
        } else if (animal.getClass().getName().equals("practice.Tom")){
            System.out.format("Spike eat Tom");
            System.out.println();
            return true;
        } else if (animal.getClass().getName().equals("practice.Spike")){
            System.out.format("Spike eat Spike");
            System.out.println();
            return true;
        } else return  false;
    }
}
