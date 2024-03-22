package airtraffic_control;

import java.util.Objects;

public class AircraftTypes {
    public static final String HELICOPTER = "Helicopter";
    public static final String JETPLANE = "JetPlane";
    public static final String BALLOON = "Balloon";

    public static boolean isAValidTypeOfAircraft(String type) {
        return (Objects.equals(type, HELICOPTER)
                || Objects.equals(type, JETPLANE)
                || Objects.equals(type, BALLOON));
    }

    public static String getTypes() {
        return String.format("%s %s %s", HELICOPTER, JETPLANE, BALLOON);
    }
}
