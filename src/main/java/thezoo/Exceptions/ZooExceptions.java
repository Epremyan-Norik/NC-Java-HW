package thezoo.Exceptions;

public class ZooExceptions extends Exception {
    public static class IncorrectName extends Exception {

        public IncorrectName(String message) {
            super(message);
        }
    }
    public static class CageNotFound extends Exception {

        public CageNotFound(String message) {
            super(message);
        }
    }

    public static class CageNotEmpty extends Exception {

        public CageNotEmpty(String message) {
            super(message);
        }
    }
}
