package aircrafts;

import io.Messages;
import towers.Coordinates;
import weather.Weather;

public class Helicopter extends Aircraft {
    public Helicopter(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate, AircraftTypes.HELICOPTER);
    }

    @Override
    public void updateConditions() {
        if (this.isLanded) {
            return;
        }
        if (this.coordinates.getHeight() != 0) {
            String weather = this.weatherTower.getWeather(this.coordinates);
            switch (weather) {
                case Weather.SUN -> coordinates.updateCoordinates(10, 0, 2);
                case Weather.RAIN -> coordinates.updateCoordinates(5, 0, 0);
                case Weather.FOG -> coordinates.updateCoordinates(1, 0, 0);
                case Weather.SNOW -> coordinates.updateCoordinates(0, 0, -12);
            }
            logMessage(AircraftTypes.HELICOPTER, NAME, ID, Messages.helicopter.get(weather));
        }
        hasTheAircraftLanded(TYPE);
    }
}
