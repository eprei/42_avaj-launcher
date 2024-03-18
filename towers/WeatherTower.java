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
        for (int i = 1; i <= numberOfTimes; i++) {
//            Log.info(String.format("___________   ITERATION %d   _____________", i));
            WeatherProvider.changeWeather();
            conditionChanged();
        }
    }
}
