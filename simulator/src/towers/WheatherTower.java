package towers;

import aircrafts.Coordinates;
import weather.WeatherProvider;

public class WheatherTower extends Tower {
    private final WeatherProvider weatherProvider;
    private final String NAME = "WeatherTower";

    public WheatherTower() {
        this.weatherProvider = WeatherProvider.getInstance();
    }

    public String getWeather(Coordinates p_coordinates) {
        return this.weatherProvider.getCurrentWeather(p_coordinates);
    }

    public void changeWeather() {
        System.out.println("changing the weather...");
        WeatherProvider.changeWeather();
        super.conditionChanged();
    }

    public String getName() {
        return this.NAME;
    }

}
