package airtraffic_control;

import exceptions.NegativeHeightException;
import exceptions.NegativeLatitudeException;
import exceptions.NegativeLongitudeException;
import log.Log;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int p_longitude, int p_latitude, int p_height) {
        this.longitude = p_longitude;
        this.latitude = p_latitude;
        int HEIGHT_LIMIT = 100;
        this.height = Math.min(p_height, HEIGHT_LIMIT);
    }

    public static void validateCoordinates(int longitude, int latitude, int height) throws Exception {
        if (longitude < 0) {
            throw new NegativeLongitudeException(String.valueOf(longitude));
        }
        if (latitude < 0) {
            throw new NegativeLatitudeException(String.valueOf(latitude));
        }
        if (height < 0) {
            throw new NegativeHeightException(String.valueOf(height));
        }
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }

    public void updateCoordinates(int longitudeVariation, int latitudeVariation, int heightVariation) {
        if (height == 0) {
            return;
        }
//        Log.info(String.format("old coordinates: lon %d lat %d hei %d", longitude, latitude, height));
        updateLongitude(longitudeVariation);
        updateLatitude(latitudeVariation);
        updateHeight(heightVariation);
//        Log.info(String.format("new coordinates: lon %d lat %d hei %d", longitude, latitude, height));
    }

    private void updateLongitude(int variation) {
        this.longitude += variation;
        if (this.longitude < 1) {
            this.longitude = 1;
        }
    }

    private void updateLatitude(int variation) {
        this.latitude += variation;
        if (this.latitude < 1) {
            this.latitude = 1;
        }
    }

    private void updateHeight(int variation) {
        this.height += variation;
        if (this.height > 100) {
            this.height = 100;
        } else if (this.height < 0) {
            this.height = 0;
        }
    }
}
