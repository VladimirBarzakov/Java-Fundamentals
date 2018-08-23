package models.boats;

import contracts.Race;

import static utility.Constants.SAIL_EFFECTIVENESS_MUST_BE_BETWEEN_1_100;

public class SailBoat extends BaseBoat {
    private int sailEfficiency;

    public SailBoat(String model, int weight, int sailEfficiency) {
        super(model, weight);
        this.setSailEfficiency(sailEfficiency);
    }

    private void setSailEfficiency(int sailEfficiency) {
        if (sailEfficiency<1 || sailEfficiency>100){
            throw new IllegalArgumentException(
                    SAIL_EFFECTIVENESS_MUST_BE_BETWEEN_1_100);
        }
        this.sailEfficiency = sailEfficiency;
    }

    @Override
    public boolean isMotorBoat() {
        return false;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
        double speed =  (race.getWindSpeed() * (this.sailEfficiency / 100d)) - this.getWeight() + (race.getOceanCurrentSpeed() / 2d);
        if (speed<0d){
            return 0d;
        }
        return speed;
    }
}
