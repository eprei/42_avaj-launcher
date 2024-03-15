public class Simulator {
    public static void main(String[] args) {
        simulate();
    }

    private static void simulate() {
        WheatherTower wheatherTower = new WheatherTower();
        Flyable jetPlane = AircraftFactory.getInstance().newAircraft(AircraftTypes.JETPLANE, "WRZ-110", new Coordinates(50, 50, 5));
        jetPlane.registerTower(wheatherTower);
        for (int i = 1; i <= 5; i++) {
            System.out.printf("_________________   ITERATION %d   ___________________\n", i);
            wheatherTower.changeWeather();
            wait(1000);
        }
    }

    private static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
