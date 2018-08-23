package models.boats;

import contracts.BoatEngine;
import contracts.Race;

public class PowerBoat extends BaseBoat {
    private BoatEngine boatEngineA;
    private BoatEngine boatEngineB;

    public PowerBoat(String model,
                     int weight,
                     BoatEngine boatEngineA,
                     BoatEngine boatEngineB) {
        super(model, weight);
        this.boatEngineA = boatEngineA;
        this.boatEngineB = boatEngineB;
    }

    @Override
    public boolean isMotorBoat() {
        return true;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
        double speed = (boatEngineA.getOutput()+boatEngineB.getOutput())- this.getWeight() + (race.getOceanCurrentSpeed() / 5d);
        if (speed<0d){
            return 0d;
        }
        return speed;
    }
}
