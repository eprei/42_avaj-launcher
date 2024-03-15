public class WheatherTower extends Tower {
    private final WeatherProvider weatherProvider;

    public WheatherTower() {
        this.weatherProvider = WeatherProvider.getInstance();
    }

    public String getWeather(Coordinates p_coordinates) {
        return this.weatherProvider.getCurrentWeather(p_coordinates);
    }

    public void changeWeather() {
        System.out.println("WeatherTower changeWeather()");
        WeatherProvider.changeWeather();
        conditionChanged();
    }
}
