package michal.kiecana.assignment.dto;

public class SetOfNumbers {
    private final double dbRandom;
    private final double javaRandom;
    private final double connected;

    public SetOfNumbers(double dbRandom, double javaRandom, double connected) {
        this.dbRandom = dbRandom;
        this.javaRandom = javaRandom;
        this.connected = connected;
    }

    public double getDbRandom() {
        return dbRandom;
    }

    public double getJavaRandom() {
        return javaRandom;
    }

    public double getConnected() {
        return connected;
    }
}
