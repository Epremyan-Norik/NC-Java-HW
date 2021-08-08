package thezoo.commandparser;

import thezoo.Zoo;

import java.util.Locale;

public class CommandRunner {
    public static boolean runCommandsFromConsole(Zoo zoo){
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

}
