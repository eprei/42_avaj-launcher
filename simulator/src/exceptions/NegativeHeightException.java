package exceptions;

public class NegativeHeightException extends SimulatorException {

    public NegativeHeightException(String value) {
        super("NegativeHeightException", value);
    }
}
