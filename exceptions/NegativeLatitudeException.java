package exceptions;

public class NegativeLatitudeException extends SimulatorException {
    public NegativeLatitudeException(String value) {
        super("NegativeLatitudeException", value);
    }
}
