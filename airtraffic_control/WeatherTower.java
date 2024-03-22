package airtraffic_control;

import weather.WeatherProvider;

public class WeatherTower extends Tower {
    private final WeatherProvider weatherProvider;

    public WeatherTower() {
        super("weather tower");
        this.weatherProvider = WeatherProvider.getInstance();
    }

    public String getWeather(Coordinates p_coordinates) {
        return this.weatherProvider.getCurrentWeather(p_coordinates);
    }

    public void changeWeather() {
        WeatherProvider.changeWeather();
        conditionChanged();
    }
}
