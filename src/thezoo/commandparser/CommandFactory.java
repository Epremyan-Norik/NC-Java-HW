package thezoo.commandparser;

import thezoo.Zoo;

import java.io.IOException;

public interface CommandFactory {
    void runCommand(String[] commands, Zoo zoo) throws CheckInImpl.InputIsNotValid;

    public class InputIsNotValid extends IOException {

        public InputIsNotValid(String message) {
            super(message);
        }
    }
}
