package aircrafts;

import weather.Weather;

import java.util.HashMap;
import java.util.Map;

public class JetPlane extends Aircraft implements updateable {
    private final Map<String, Runnable> updateCoordinatesMethods;

    public JetPlane(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);

        this.updateCoordinatesMethods = new HashMap<>();
        this.updateCoordinatesMethods.put(Weather.TYPES.get(0), this::updateCoordinatesForSun);
        this.updateCoordinatesMethods.put(Weather.TYPES.get(1), this::updateCoordinatesForRain);
        this.updateCoordinatesMethods.put(Weather.TYPES.get(2), this::updateCoordinatesForFog);
        this.updateCoordinatesMethods.put(Weather.TYPES.get(3), this::updateCoordinatesForSnow);
    }

    @Override
    public void updateConditions() {
        if (super.coordinates.getHeight() == 0) {
            return;
        }
        System.out.printf("%s recived signal from %s -> updating conditions...\n", this.name, wheatherTower.getName());
        String weather = this.wheatherTower.getWeather(this.coordinates);
        System.out.printf("%s has get the new weather at %d %d %d: %s\n", this.name, coordinates.getLongitude(),
                coordinates.getLatitude(), coordinates.getHeight(), weather);
        updateCoordinatesMethods.get(weather).run();
        super.HasTheAircraftLanded();
    }

    private void updateCoordinatesForSun() {
        System.out.printf("SUN old coordinates: %d %d %d ", coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight());
        super.coordinates.updateCoordinates(0, 10, 2);
        System.out.printf("new coordinates: %d %d %d\n", coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight());
    }

    private void updateCoordinatesForRain() {
        System.out.printf("RAIN old coordinates: %d %d %d ", coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight());
        super.coordinates.updateCoordinates(0, 5, 0);
        System.out.printf("new coordinates: %d %d %d\n", coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight());
    }

    private void updateCoordinatesForFog() {
        System.out.printf("FOG old coordinates: %d %d %d ", coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight());
        super.coordinates.updateCoordinates(0, 1, 0);
        System.out.printf("new coordinates: %d %d %d\n", coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight());
    }

    private void updateCoordinatesForSnow() {
        System.out.printf("SNOW old coordinates: %d %d %d ", coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight());
        super.coordinates.updateCoordinates(0, 0, 7);
        System.out.printf("new coordinates: %d %d %d\n", coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight());
    }
}
