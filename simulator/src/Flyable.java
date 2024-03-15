public abstract class Flyable {
    protected WheatherTower wheatherTower;

    public abstract void updateConditions();

    public void registerTower(WheatherTower p_tower) {
        this.wheatherTower = p_tower;
        p_tower.register(this);
    }
}
