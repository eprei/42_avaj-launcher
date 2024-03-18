import aircrafts.Flyable;
import exceptions.SimulatorException;
import io.FileManager;
import towers.WeatherTower;

import java.util.ArrayList;
import java.util.List;

public class Simulator {
    private static List<Flyable> LIST_OF_FLYABLE = new ArrayList<>();
    private static int NUMBER_OF_SIMULATIONS = 0;

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.print("Error: incorrect number of arguments\n");
            System.out.print("Usage: java avaj-launcher.simulator.Simulator SCENARIO_FILE.txt");
            return;
        }
        try {
            FileManager.openFile(args[0]);
            NUMBER_OF_SIMULATIONS = FileManager.getNumberOfSimulations();
            LIST_OF_FLYABLE = FileManager.getListOfFlyable();
            simulate();
            FileManager.saveLogToFile();
        } catch (SimulatorException e) {
            System.out.printf(e.getInfo());
        } catch (Exception e) {
            System.out.printf("Error: %s", e);
        }
    }

    private static void simulate() {
        WeatherTower weatherTower = new WeatherTower();

        LIST_OF_FLYABLE.forEach(flyable -> flyable.registerTower(weatherTower));
        weatherTower.changeWeather(NUMBER_OF_SIMULATIONS);
    }
}
