package thezoo.commandparser;

import thezoo.Zoo;
import thezoo.ZooImpl;

public class CheckOutImpl implements CommandFactory {

    @Override
    public void runCommand(String[] commands, Zoo zoo) throws InputIsNotValid {

        if(commands.length==0) {
            throw new InputIsNotValid("Too few argument. Right example: check-out <Name>");
        }
        try{
            zoo.checkOutAnimal(commands[0]);
        }
        catch (ZooImpl.IncorrectName exc){
            exc.printStackTrace();
        }
    }
}
