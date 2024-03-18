package exceptions;

public class InvalidNumberOfSimulationsFormatException extends SimulatorException {
    public InvalidNumberOfSimulationsFormatException(String value) {
        super("InvalidNumberOfSimulationsFormatException", value);
    }

    public String getInfo() {
        return String.format("%s %s\nThe number of simulations must be an int > 0", name, value);
    }
}
