package factories;

import aircrafts.AircraftTypes;
import aircrafts.Coordinates;
import aircrafts.Flyable;

public class JetPlaneFactory {
    private static final AircraftFactory aircraftFactory = AircraftFactory.getInstance();

    public static Flyable createJetPlane(String p_name, Coordinates p_coordinates) {
        System.out.printf("JetPlane %s has been created at %d %d %d\n", p_name, p_coordinates.getLongitude(), p_coordinates.getLatitude(), p_coordinates.getHeight());
        return aircraftFactory.newAircraft(AircraftTypes.JETPLANE, p_name, p_coordinates);
    }
}
