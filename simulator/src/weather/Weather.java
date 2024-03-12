package weather;

import java.util.Map;

public class Weather {
    public static final Map<Integer, String> TYPES;

    static {
        TYPES = Map.of(0, "sun", 1, "rain", 2, "fog", 3, "snow");
    }
}
