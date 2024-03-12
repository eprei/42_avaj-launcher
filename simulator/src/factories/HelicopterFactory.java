package factories;

import aircrafts.AircraftTypes;
import aircrafts.Coordinates;
import aircrafts.Flyable;

public class HelicopterFactory {
    private static AircraftFactory aircraftFactory;

    public static Flyable createHelicopter(String p_name, Coordinates p_coordinates) {
        return aircraftFactory.newAircraft(AircraftTypes.HELICOPTER, p_name, p_coordinates);
    }
}
