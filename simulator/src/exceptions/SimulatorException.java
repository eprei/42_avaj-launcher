package exceptions;

public class SimulatorException extends Exception {
    private final int value;
    private final String name;

    public SimulatorException(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getInfo() {
        return String.format("%s: %s", name, value);
    }

}
