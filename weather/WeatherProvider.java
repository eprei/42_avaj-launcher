package weather;

import towers.Coordinates;

public class WeatherProvider {
    private static final String[] weather = {
            Weather.SUN,
            Weather.RAIN,
            Weather.FOG,
            Weather.SNOW
    };
    private static WeatherProvider instance;
    private static int changeWeather = 0;

    private WeatherProvider() {
    }

    public static WeatherProvider getInstance() {
        if (instance == null) {
            instance = new WeatherProvider();
        }
        return instance;
    }

    public static void changeWeather() {
        changeWeather += 1;
    }

    public String getCurrentWeather(Coordinates p_coordinates) {
        int randomSeed = (p_coordinates.getLongitude() + p_coordinates.getLatitude() +
                p_coordinates.getHeight() + changeWeather) % 4;
        // uniform weather
        // int randomSeed = changeWeather % 4;
        return weather[randomSeed];
    }
}
