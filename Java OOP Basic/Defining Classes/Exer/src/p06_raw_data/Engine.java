package p06_raw_data;

public class Engine {
    private long engineSpeed;
    private long enginePower;

    public Engine() {
    }

    public Engine(long engineSpeed, long enginePower) {
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
    }

    public long getEngineSpeed() {
        return engineSpeed;
    }

    public long getEnginePower() {
        return enginePower;
    }
}
