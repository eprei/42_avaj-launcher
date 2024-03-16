package aircrafts;

import towers.Coordinates;

public class Aircraft extends Flyable {
    protected final long ID;
    protected final String NAME;
    protected final String TYPE;
    protected Coordinates coordinates;
    protected boolean isLanded;

    public Aircraft(long p_id, String p_name, Coordinates p_coordinates, String type) {
        this.ID = p_id;
        this.NAME = p_name;
        this.coordinates = p_coordinates;
        TYPE = type;
        this.isLanded = false;
    }

    protected void printMessage(String type, String name, long id, String message) {
        System.out.printf("%s#%s(%d): %s\n", type, name, id, message);
    }

    @Override
    public void updateConditions() {
    }

    public String getName() {
        return NAME;
    }

    public long getId() {
        return ID;
    }

    public String getType() {
        return TYPE;
    }

    protected void hasTheAircraftLanded(String type) {
        if (coordinates.getHeight() == 0) {
            isLanded = true;
            printMessage(type, NAME, ID, "landing.");
            weatherTower.unregister(this);
        }
    }

//    private void updateHelicopterCoordinates(String weather) {
//        switch (weather) {
//            case Weather.SUN -> coordinates.updateCoordinates(10, 0, 2);
//            case Weather.RAIN -> coordinates.updateCoordinates(5, 0, 0);
//            case Weather.FOG -> coordinates.updateCoordinates(1, 0, 0);
//            case Weather.SNOW -> coordinates.updateCoordinates(0, 0, -12);
//        }
//        printMessage(AircraftTypes.HELICOPTER, NAME, ID, Messages.helicopter.get(weather));
//    }

//    private void updateBalloonCoordinates(String weather) {
//        switch (weather) {
//            case Weather.SUN -> coordinates.updateCoordinates(10, 0, 2);
//            case Weather.RAIN -> coordinates.updateCoordinates(5, 0, 0);
//            case Weather.FOG -> coordinates.updateCoordinates(1, 0, 0);
//            case Weather.SNOW -> coordinates.updateCoordinates(0, 0, -12);
//        }
//        printMessage(AircraftTypes.BALLOON, NAME, ID, Messages.balloon.get(weather));
//    }
}
