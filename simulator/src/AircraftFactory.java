public class AircraftFactory {
    private static int uuid = 1;
    private static AircraftFactory instance;

    private AircraftFactory() {
    }

    public static AircraftFactory getInstance() {
        if (instance == null) {
            instance = new AircraftFactory();
        }
        return instance;
    }

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
        return switch (p_type) {
            case AircraftTypes.HELICOPTER -> new Helicopter(uuid++, p_name, p_coordinates);
            case AircraftTypes.JETPLANE -> new JetPlane(uuid++, p_name, p_coordinates);
            case AircraftTypes.BALLOON -> new Balloon(uuid++, p_name, p_coordinates);
//            TODO HANDLE NULL POINTER EXCEPTION
            default -> null;
        };
    }

}
