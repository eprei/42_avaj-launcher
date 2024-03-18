package exceptions;

public class SimulatorException extends Exception {
    protected final String value;
    protected final String name;

    public SimulatorException(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getInfo() {
        return String.format("%s: %s", name, value);
    }

}
