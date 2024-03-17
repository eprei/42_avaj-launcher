package io;

import aircrafts.AircraftFactory;
import aircrafts.Flyable;
import towers.Coordinates;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private static final List<Flyable> LIST_OF_FLYABLE = new ArrayList<>();
    private static final AircraftFactory aircraftFactory = AircraftFactory.getInstance();
    private static int NUMBER_OF_SIMULATIONS = 0;

    public static void openFile(String[] args) throws Exception {
        String path = args[0];

        try (FileReader fileReader = new FileReader(path);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            NUMBER_OF_SIMULATIONS = Integer.parseInt(bufferedReader.readLine());
            // TODO throw exception if NUMBER_OF_SIMULATIONS != int or NUMBER_OF_SIMULATIONS < 1
            while ((line = bufferedReader.readLine()) != null) {
                parseLine(line);
            }
        }
    }

    private static void parseLine(String line) throws Exception {
        String[] parts = line.split(" ");

        if (parts.length != 5) {
            // TODO throw exception
            return;
        }

        String type = parts[0];
        // TODO throw exception if type not in AircfraftTypes
        String name = parts[1];
        int longitude = Integer.parseInt(parts[2]);
        int latitude = Integer.parseInt(parts[3]);
        int height = Integer.parseInt(parts[4]);

        Coordinates.validateCoordinates(longitude, latitude, height);

        Flyable flyable = aircraftFactory.newAircraft(type, name, new Coordinates(longitude, latitude, height));
        LIST_OF_FLYABLE.add(flyable);
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
