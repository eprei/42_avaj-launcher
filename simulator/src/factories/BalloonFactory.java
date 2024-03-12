package factories;

import aircrafts.AircraftTypes;
import aircrafts.Coordinates;
import aircrafts.Flyable;

public class BalloonFactory {
    private static AircraftFactory aircraftFactory;

    public static Flyable createBalloon(String p_name, Coordinates p_coordinates) {
        return aircraftFactory.newAircraft(AircraftTypes.BALLOON, p_name, p_coordinates);
    }
}
