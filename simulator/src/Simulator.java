import aircrafts.AircraftFactory;
import aircrafts.AircraftTypes;
import aircrafts.Flyable;
import towers.Coordinates;
import towers.WeatherTower;

public class Simulator {
    public static void main(String[] args) {
        simulate();
    }

    private static void simulate() {
        WeatherTower weatherTower = new WeatherTower();
        Flyable jetPlane = AircraftFactory.getInstance().newAircraft(AircraftTypes.JETPLANE, "Airbus", new Coordinates(60, 60, 60));
        Flyable helicopter = AircraftFactory.getInstance().newAircraft(AircraftTypes.HELICOPTER, "Apache", new Coordinates(70, 70, 70));
        Flyable balloon = AircraftFactory.getInstance().newAircraft(AircraftTypes.BALLOON, "Aerostatico", new Coordinates(30, 30, 30));
        jetPlane.registerTower(weatherTower);
        helicopter.registerTower(weatherTower);
        balloon.registerTower(weatherTower);
        for (int i = 1; i <= 5; i++) {
            System.out.printf("___________   ITERATION %d   _____________\n", i);
            weatherTower.changeWeather();
            wait(1000);
        }
    }

    private static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}