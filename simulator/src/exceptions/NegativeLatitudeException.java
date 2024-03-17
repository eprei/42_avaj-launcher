package exceptions;

public class NegativeLatitudeException extends SimulatorException {
    public NegativeLatitudeException(int value) {
        super("NegativeLatitudeException", value);
    }
}
