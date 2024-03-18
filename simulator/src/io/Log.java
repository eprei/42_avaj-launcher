package io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Log {
    private static final StringBuilder LOG_MESSAGES = new StringBuilder();
    private static final String FILE_NAME = "simulation.txt";

    public static void info(String message) {
        LOG_MESSAGES.append(message).append("\n");
    }

    public static void saveLogToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write(LOG_MESSAGES.toString());
        } catch (IOException e) {
            System.out.printf("An error occurred while saving the file %s: %s", FILE_NAME, e);
        }
    }
}
