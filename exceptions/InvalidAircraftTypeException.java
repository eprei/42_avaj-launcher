package exceptions;

import airtraffic_control.AircraftTypes;

public class InvalidAircraftTypeException extends SimulatorException {
    public InvalidAircraftTypeException(String value) {
        super("InvalidAircraftTypeException", value);
    }

    public String getInfo() {
        return String.format("%s at line: %s\nValid aircraft types are: %s", name, value, AircraftTypes.getTypes());
    }

}
