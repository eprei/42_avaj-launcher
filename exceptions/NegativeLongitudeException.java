package exceptions;

public class NegativeLongitudeException extends SimulatorException {
    public NegativeLongitudeException(String value) {
        super("NegativeLongitudeException", value);
    }
}
