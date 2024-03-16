package aircrafts;

import notifications.Messages;
import towers.Coordinates;
import weather.Weather;

public class Balloon extends Aircraft {
    public Balloon(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate, AircraftTypes.BALLOON);
    }

    @Override
    public void updateConditions() {
        if (this.isLanded) {
            return;
        }
        System.out.printf("%s recived signal from %s -> updating conditions...\n", this.NAME, weatherTower.getName());
        String weather = this.weatherTower.getWeather(this.coordinates);
        System.out.printf("%s has get the new weather at %d %d %d: %s\n", this.NAME, coordinates.getLongitude(),
                coordinates.getLatitude(), coordinates.getHeight(), weather);
        switch (weather) {
            case Weather.SUN -> coordinates.updateCoordinates(2, 0, 4);
            case Weather.RAIN -> coordinates.updateCoordinates(0, 0, -5);
            case Weather.FOG -> coordinates.updateCoordinates(0, 0, -3);
            case Weather.SNOW -> coordinates.updateCoordinates(0, 0, -15);
        }
        printMessage(AircraftTypes.BALLOON, NAME, ID, Messages.balloon.get(weather));
        hasTheAircraftLanded(TYPE);
    }
}
