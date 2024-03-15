public class Helicopter extends Aircraft implements updateable {
    private final String TYPE = AircraftTypes.HELICOPTER;

    public Helicopter(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }

    @Override
    public void updateConditions() {
        if (super.coordinates.getHeight() == 0) {
            return;
        }
        System.out.printf("%s recived signal from %s -> updating conditions...\n", this.NAME, wheatherTower.getName());
        String weather = this.wheatherTower.getWeather(this.coordinates);
        System.out.printf("%s has get the new weather at %d %d %d: %s\n", this.NAME, coordinates.getLongitude(),
                coordinates.getLatitude(), coordinates.getHeight(), weather);
        updateCoordinates(TYPE, weather);
    }

}
