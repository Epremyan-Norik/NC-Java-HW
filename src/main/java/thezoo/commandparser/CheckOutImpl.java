package thezoo.commandparser;

import thezoo.Exceptions.ZooExceptions;
import thezoo.Zoo;

public class CheckOutImpl implements CommandFactory {

    @Override
    public void runCommand(String[] commands, Zoo zoo) throws InputIsNotValid {

        if(commands.length==0) {
            throw new InputIsNotValid("Too few argument. Right example: check-out <Name>");
        }
        try{
            zoo.checkOutAnimal(commands[0]);
        }
        catch (ZooExceptions.IncorrectName exc){
            exc.printStackTrace();
        }
    }
}
