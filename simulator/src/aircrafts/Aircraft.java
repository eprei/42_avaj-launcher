package aircrafts;

public class Aircraft extends Flyable {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    protected boolean isLanded;

    public Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinates;
        this.isLanded = false;
    }

    @Override
    public void updateConditions() {
    }

    protected void HasTheAircraftLanded() {
        if (coordinates.getHeight() == 0) {
            isLanded = true;
            System.out.printf("%s has been landed", this.name);
            super.wheatherTower.unregister(this);
        }
    }
}
