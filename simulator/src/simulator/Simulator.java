package simulator;

import aircrafts.Coordinates;
import aircrafts.Flyable;
import factories.JetPlaneFactory;
import towers.WheatherTower;

public class Simulator {
    public static void main(String[] args) {
        simulate();
    }

    private static void simulate() {
        WheatherTower wheatherTower = new WheatherTower();
        Flyable jetPlane = JetPlaneFactory.createJetPlane("WRZ-110", new Coordinates(50, 50, 50));
        jetPlane.registerTower(wheatherTower);
        for (int i = 0; i < 5; i++) {
            wheatherTower.changeWeather();
        }
    }
}
