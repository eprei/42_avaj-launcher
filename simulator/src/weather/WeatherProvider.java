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
//        TODO activate next line to calculate dynamically the weather
//        int randomSeed = (p_coordinates.getLongitude() + p_coordinates.getLatitude() +
//                p_coordinates.getHeight() + changeWeather) % 4;
        int randomSeed = changeWeather % 4;
//        TODO delete next line, its just to test weather temporally
        return weather[randomSeed];
    }
}
