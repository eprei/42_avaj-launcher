package weather;

import aircrafts.Coordinates;

public class WeatherProvider {
    private static WeatherProvider instance;
    private static int changeWeather = 0;

    private final String[] weather = {Weather.TYPES.get(0),
            Weather.TYPES.get(1),
            Weather.TYPES.get(2),
            Weather.TYPES.get(3)};

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
//        int randomSeed = (p_coordinates.getLongitude() + p_coordinates.getLatitude() +
//                p_coordinates.getHeight() + changeWeather) % 4;
        int randomSeed = changeWeather % 4;
        System.out.printf("WeatherProvider: weather at %d %d %d is %s\n", p_coordinates.getLongitude(), p_coordinates.getLatitude(),
                p_coordinates.getHeight(), weather[randomSeed]);
        return weather[randomSeed];
    }
}
