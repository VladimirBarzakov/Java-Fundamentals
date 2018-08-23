package models.engines;

public class SterndriveEngine extends BaseBoatEngine {
    private static final int MULTIPLIER = 7;
    public SterndriveEngine(String model, int horsepower, int displacement) {
        super(model, horsepower, displacement, MULTIPLIER);
    }
}
