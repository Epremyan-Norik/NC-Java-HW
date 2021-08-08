package thezoo.commandparser;

import thezoo.Exceptions.ZooExceptions;
import thezoo.Zoo;
import thezoo.ZooImpl;
import thezoo.implementation.AnimalBuilder;
import thezoo.implementation.BuilderDirector;
import thezoo.model.Animal;

import java.util.Locale;

public class CheckInImpl implements CommandFactory{


    @Override
    public void runCommand(String[] commands, Zoo zoo) throws InputIsNotValid {

        BuilderDirector director = new BuilderDirector();

        AnimalBuilder builder = new AnimalBuilder();

        commands[0] = commands[0].toLowerCase(Locale.ROOT);

        if(commands.length<2){
            throw new InputIsNotValid("Too few argument. Right example: check-in <Species> <Name>");
        }

        switch (commands[0]){
            case ("leon"):{
                director.makeLeon(builder, commands[1]);

                Animal newAnimal = builder.getResult();
                try {
                    zoo.checkInAnimal(newAnimal);
                }
                catch (ZooExceptions.IncorrectName exc){
                    System.out.println("Name already exist: "+ newAnimal.getName());
                }
                catch (ZooExceptions.CageNotFound exc){
                    System.out.println("Zoo have no cage for "+ newAnimal.getName());
                }
                break;
            }
            case ("giraffe"):{
                director.makeGiraffe(builder, commands[1]);

                Animal newAnimal = builder.getResult();

                try {
                    zoo.checkInAnimal(newAnimal);
                }
                catch (ZooExceptions.IncorrectName exc){
                    System.out.println("Name already exist: "+ newAnimal.getName());
                }
                catch (ZooExceptions.CageNotFound exc){
                    System.out.println("Zoo have no cage for "+ newAnimal.getName());
                }
                break;
            }
            case ("penguin"):{
                director.makePenguin(builder, commands[1]);

                Animal newAnimal = builder.getResult();

                try {
                    zoo.checkInAnimal(newAnimal);
                }
                catch (ZooExceptions.IncorrectName exc){
                    System.out.println("Name already exist: "+ newAnimal.getName());
                }
                catch (ZooExceptions.CageNotFound exc){
                    System.out.println("Zoo have no cage for "+ newAnimal.getName());
                }
                break;
            }
            case ("squirrel"):{
                director.makeSquirrel(builder, commands[1]);

                Animal newAnimal = builder.getResult();

                try {
                    zoo.checkInAnimal(newAnimal);
                }
                catch (ZooExceptions.IncorrectName exc){
                    System.out.println("Name already exist: "+ newAnimal.getName());
                }
                catch (ZooExceptions.CageNotFound exc){
                    System.out.println("Zoo have no cage for "+ newAnimal.getName());
                }
                break;
            }
            default:{
                throw new InputIsNotValid("Unknown Animal Species. Check-in aborted");
            }

        }
    }

}
