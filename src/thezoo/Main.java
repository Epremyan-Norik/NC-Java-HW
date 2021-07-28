package thezoo;

import thezoo.commandparser.*;
import thezoo.implementation.*;
import thezoo.model.*;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        Zoo zoo = new ZooImpl();
        zoo.putCage(200, new СonditionImpl(Species.LEON));
        zoo.putCage(200, new СonditionImpl(Species.PENGUIN));
        zoo.putCage(200, new СonditionImpl(Species.GIRAFFE));
        zoo.putCage(200, new СonditionImpl(Species.SQUIRREL));


        while (runCommandsFromConsole(zoo));

    }

    public static boolean runCommandsFromConsole(Zoo zoo){
        printCommandList();
        String[] commands  = new Parser().getCommand();
        commands[0]= commands[0].toLowerCase(Locale.ROOT);

        String[] nextCommand = new String[commands.length - 1];
        if (commands.length>1){
            for (int i = 0; i < commands.length - 1; i++) {
                nextCommand[i] = commands[i + 1];
            }
        }


        switch (commands[0]) {
            case ("check-in"): {
                CommandFactory checkIn = new CheckInImpl();
                try {
                    checkIn.runCommand(nextCommand, zoo);
                }
                catch (CheckInImpl.InputIsNotValid exc){
                    exc.printStackTrace();
                }
                break;
            }
            case ("check-out"): {
                CommandFactory checkOut = new CheckOutImpl();
                try {
                    checkOut.runCommand(nextCommand, zoo);
                }
                catch (CheckInImpl.InputIsNotValid exc){
                    exc.printStackTrace();
                }
                break;
            }
            case ("log"): {
                CommandFactory log = new PrintLog();
                try {
                    log.runCommand(nextCommand, zoo);
                }
                catch (CheckInImpl.InputIsNotValid exc){
                    exc.printStackTrace();
                }
                break;
            }
            case ("exit"): {
                return false;
            }
            default: {
                System.out.println("Unknown Command");
            }
        }

        return true;
    };

    public static void printCommandList(){
        System.out.println("Commands :" + "\n"
                + "1.check-in" + "\n"
                + "2.check-out" + "\n"
                + "3.log" + "\n"
                + "4.Exit");
    }
}
