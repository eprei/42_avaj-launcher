import java.util.HashMap;
import java.util.Map;

public class Messages {
    public static Map<String, String> jetPlane = new HashMap<>();
    public static Map<String, String> helicopter = new HashMap<>();
    public static Map<String, String> balloon = new HashMap<>();
    public static String UNREGISTERED = "unregistered from weather tower.";

    // TODO write funny messages
    static {
        jetPlane.put(Weather.SUN, "Caliente el avion.");
        jetPlane.put(Weather.RAIN, "Mojado el avion.");
        jetPlane.put(Weather.FOG, "Brumoso el avion.");
        jetPlane.put(Weather.SNOW, "Nevado el avion.");

        helicopter.put(Weather.SUN, "Hot in the helicopter.");
        helicopter.put(Weather.RAIN, "Raining in the helicopter.");
        helicopter.put(Weather.FOG, "Foggy in the helicopter.");
        helicopter.put(Weather.SNOW, "Snowing in the helicopter.");

        balloon.put(Weather.SUN, "Balloon Sun.");
        balloon.put(Weather.RAIN, "Balloon Rain.");
        balloon.put(Weather.FOG, "Balloon Fog.");
        balloon.put(Weather.SNOW, "Balloon Snow.");
    }
}
