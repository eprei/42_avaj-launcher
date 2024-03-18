package aircrafts;

import io.Messages;
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
        if (this.coordinates.getHeight() != 0) {
            String weather = this.weatherTower.getWeather(this.coordinates);
            switch (weather) {
                case Weather.SUN -> coordinates.updateCoordinates(2, 0, 4);
                case Weather.RAIN -> coordinates.updateCoordinates(0, 0, -5);
                case Weather.FOG -> coordinates.updateCoordinates(0, 0, -3);
                case Weather.SNOW -> coordinates.updateCoordinates(0, 0, -15);
            }
            logMessage(AircraftTypes.BALLOON, NAME, ID, Messages.balloon.get(weather));
        }
        hasTheAircraftLanded(TYPE);
    }
}
