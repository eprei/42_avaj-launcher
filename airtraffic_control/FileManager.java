package airtraffic_control;

import exceptions.InvalidAircraftLineFormatException;
import exceptions.InvalidAircraftTypeException;
import exceptions.InvalidNumberOfSimulationsFormatException;
import log.Log;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private static final List<Flyable> LIST_OF_FLYABLE = new ArrayList<>();
    private static final AircraftFactory aircraftFactory = AircraftFactory.getInstance();
    private static int NUMBER_OF_SIMULATIONS = 0;

    public static void openFile(String path) throws Exception {

        try (FileReader fileReader = new FileReader(path);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;

            NUMBER_OF_SIMULATIONS = Integer.parseInt(bufferedReader.readLine());
            if (NUMBER_OF_SIMULATIONS < 0) {
                throw new InvalidNumberOfSimulationsFormatException(
                        String.format("For input string: \"%s\"", NUMBER_OF_SIMULATIONS));
            }
            while ((line = bufferedReader.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }
                parseLine(line);
            }
        } catch (NumberFormatException e) {
            throw new InvalidNumberOfSimulationsFormatException(e.getMessage());
        }
    }

    private static void parseLine(String line) throws Exception {
        String[] parts = line.split(" ");

        if (parts.length != 5) {
            throw new InvalidAircraftLineFormatException(line);
        }
        String type = parts[0];
        if (!AircraftTypes.isAValidTypeOfAircraft(type)) {
            throw new InvalidAircraftTypeException(line);
        }
        String name = parts[1];
        try {
            int longitude = Integer.parseInt(parts[2]);
            int latitude = Integer.parseInt(parts[3]);
            int height = Integer.parseInt(parts[4]);

            Coordinates.validateCoordinates(longitude, latitude, height);
            Flyable flyable = aircraftFactory.newAircraft(type, name, new Coordinates(longitude, latitude, height));
            LIST_OF_FLYABLE.add(flyable);
        } catch (NumberFormatException e) {
            throw new InvalidAircraftLineFormatException(line);
        }
    }

    public static int getNumberOfSimulations() {
        return NUMBER_OF_SIMULATIONS;
    }

    public static List<Flyable> getListOfFlyable() {
        return LIST_OF_FLYABLE;
    }

    public static void saveLogToFile() {
        Log.saveLogToFile();
    }
}
