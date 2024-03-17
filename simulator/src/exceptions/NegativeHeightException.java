package exceptions;

public class NegativeHeightException extends SimulatorException {

    public NegativeHeightException(int value) {
        super("NegativeHeightException", value);
    }
}
