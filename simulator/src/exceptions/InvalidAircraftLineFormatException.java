package exceptions;

public class InvalidAircraftLineFormatException extends SimulatorException {
    public InvalidAircraftLineFormatException(String value) {
        super("InvalidAircraftLineFormatException", value);
    }

    public String getInfo() {
        return String.format("%s at line: %s\nExpected line format: TYPE(String) NAME(String) LONGITUDE(int > 0) " +
                "LATITUDE(int > 0) HEIGHT(int > 0)", name, value);
    }
}
