package aircrafts;

import io.Log;
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

    protected void logMessage(String type, String name, long id, String message) {
//        System.out.printf("%s#%s(%d): %s\n", type, name, id, message);
        String messageFormatted = String.format("%s#%s(%d): %s", type, name, id, message);
        Log.info(messageFormatted);
    }

    @Override
    public void updateConditions() {
        //TODO solve this methode
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
            logMessage(type, NAME, ID, "landing.");
            weatherTower.unregister(this);
        }
    }
}
