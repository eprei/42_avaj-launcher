public class Aircraft extends Flyable {
    protected final long ID;
    protected final String NAME;
    protected Coordinates coordinates;
    protected boolean isLanded;

    public Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
        this.ID = p_id;
        this.NAME = p_name;
        this.coordinates = p_coordinates;
        this.isLanded = false;
    }

    private static void printMessage(String type, String name, long id, String message) {
        System.out.printf("%s#%s(%d): %s\n", type, name, id, message);
    }

    @Override
    public void updateConditions() {
    }

    protected void HasTheAircraftLanded(String type) {
        if (coordinates.getHeight() == 0) {
            isLanded = true;
            printMessage(type, NAME, ID, "landing.");
            System.out.printf("%s says: ", wheatherTower.getName());
            System.out.printf("%s#%s(%d) %s\n", type, NAME, ID, Messages.UNREGISTERED);
            super.wheatherTower.unregister(this);
        }
    }

    protected void updateCoordinates(String type, String weather) {
        switch (type) {
            case AircraftTypes.HELICOPTER -> updateHelicopterCoordinates(weather);
            case AircraftTypes.JETPLANE -> updateJetPlaneCoordinates(weather);
            case AircraftTypes.BALLOON -> updateBalloonCoordinates(weather);
        }
        HasTheAircraftLanded(type);
    }

    private void updateJetPlaneCoordinates(String weather) {
        switch (weather) {
            case Weather.SUN -> coordinates.updateCoordinates(0, 10, 2);
            case Weather.RAIN -> coordinates.updateCoordinates(0, 5, 0);
            case Weather.FOG -> coordinates.updateCoordinates(0, 1, 0);
            case Weather.SNOW -> coordinates.updateCoordinates(0, 0, -7);
        }
        printMessage(AircraftTypes.JETPLANE, NAME, ID, Messages.jetPlane.get(weather));
    }

    private void updateHelicopterCoordinates(String weather) {
        switch (weather) {
            case Weather.SUN -> coordinates.updateCoordinates(10, 0, 2);
            case Weather.RAIN -> coordinates.updateCoordinates(5, 0, 0);
            case Weather.FOG -> coordinates.updateCoordinates(1, 0, 0);
            case Weather.SNOW -> coordinates.updateCoordinates(0, 0, -12);
        }
        printMessage(AircraftTypes.HELICOPTER, NAME, ID, Messages.helicopter.get(weather));
    }

    private void updateBalloonCoordinates(String weather) {
        switch (weather) {
            case Weather.SUN -> coordinates.updateCoordinates(10, 0, 2);
            case Weather.RAIN -> coordinates.updateCoordinates(5, 0, 0);
            case Weather.FOG -> coordinates.updateCoordinates(1, 0, 0);
            case Weather.SNOW -> coordinates.updateCoordinates(0, 0, -12);
        }
        printMessage(AircraftTypes.BALLOON, NAME, ID, Messages.balloon.get(weather));
    }
}
