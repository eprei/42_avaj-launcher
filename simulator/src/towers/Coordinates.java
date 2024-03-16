package towers;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    public Coordinates(int p_longitude, int p_latitude, int p_height) {
        this.longitude = p_longitude;
        this.latitude = p_latitude;
        this.height = p_height;
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
        System.out.printf("old coordinates: %d %d %d\n", longitude, latitude, height);
        updateLongitude(longitudeVariation);
        updateLatitude(latitudeVariation);
        updateHeight(heightVariation);
        System.out.printf("new coordinates: %d %d %d\n", longitude, latitude, height);
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
