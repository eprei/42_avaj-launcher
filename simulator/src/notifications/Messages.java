package notifications;

import weather.Weather;

import java.util.HashMap;
import java.util.Map;

public class Messages {
    public static String REGISTERED = "registered to";
    public static String UNREGISTERED = "unregistered from";
    public static Map<String, String> jetPlane = new HashMap<>();
    public static Map<String, String> helicopter = new HashMap<>();
    public static Map<String, String> balloon = new HashMap<>();

    static {
        jetPlane.put(Weather.SUN, "This plane is caliente.");
        jetPlane.put(Weather.RAIN, "It's raining. Better watch out for lightnings.");
        jetPlane.put(Weather.FOG, "Fog is not a problem for this jet.");
        jetPlane.put(Weather.SNOW, "OMG! Winter is coming!");

        helicopter.put(Weather.SUN, "This is hot.");
        helicopter.put(Weather.RAIN, "Raining in the helicopter.");
        helicopter.put(Weather.FOG, "Foggy in the helicopter.");
        helicopter.put(Weather.SNOW, "My rotor is going to freeze!");

        balloon.put(Weather.SUN, "Let's enjoy the good weather and take some pics.");
        balloon.put(Weather.RAIN, "Damn you rain! You messed up my balloon.");
        balloon.put(Weather.FOG, "In this fog we can't see a thing!");
        balloon.put(Weather.SNOW, "It's snowing. We're gonna crash.");
    }
}
