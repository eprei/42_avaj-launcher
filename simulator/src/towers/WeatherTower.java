package towers;

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

    public void changeWeather(int numberOfTimes) {
        for (int i = 0; i <= numberOfTimes; i++) {
            System.out.printf("___________   ITERATION %d   _____________\n", i);
            System.out.println("WeatherTower changeWeather()");
            WeatherProvider.changeWeather();
            conditionChanged();
        }
    }
}
