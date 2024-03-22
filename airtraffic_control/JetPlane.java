package airtraffic_control;

import log.Messages;
import weather.Weather;

public class JetPlane extends Aircraft {
    public JetPlane(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate, AircraftTypes.JETPLANE);
    }

    @Override
    public void updateConditions() {
        if (this.isLanded) {
            return;
        }
        if (this.coordinates.getHeight() != 0) {
            String weather = this.weatherTower.getWeather(this.coordinates);
            switch (weather) {
                case Weather.SUN -> coordinates.updateCoordinates(0, 10, 2);
                case Weather.RAIN -> coordinates.updateCoordinates(0, 5, 0);
                case Weather.FOG -> coordinates.updateCoordinates(0, 1, 0);
                case Weather.SNOW -> coordinates.updateCoordinates(0, 0, -7);
            }
            logMessage(AircraftTypes.JETPLANE, NAME, ID, Messages.jetPlane.get(weather));
        }
        hasTheAircraftLanded(TYPE);
    }
}
