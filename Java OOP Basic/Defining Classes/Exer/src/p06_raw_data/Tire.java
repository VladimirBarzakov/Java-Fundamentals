package p06_raw_data;

public class Tire {

    private long tireAge;
    private double tirePressure;

    public Tire() {
    }

    public Tire(long tireAge, double tirePressure) {
        this.tireAge = tireAge;
        this.tirePressure = tirePressure;
    }

    public long getTireAge() {
        return tireAge;
    }

    public double getTirePressure() {
        return tirePressure;
    }
}
