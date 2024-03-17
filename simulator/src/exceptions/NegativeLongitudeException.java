package exceptions;

public class NegativeLongitudeException extends SimulatorException {
    public NegativeLongitudeException(int value) {
        super("NegativeLongitudeException", value);
    }
}
