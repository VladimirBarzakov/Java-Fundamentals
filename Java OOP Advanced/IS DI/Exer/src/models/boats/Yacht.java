package models.boats;

import contracts.BoatEngine;
import contracts.Race;

import static utility.Constants.S_MUST_BE_A_POSITIVE_INTEGER;

public class Yacht extends BaseBoat {
    private BoatEngine boatEngine;
    private int cargoWeight;

    public Yacht(String model,
                 int weight,
                 BoatEngine boatEngine,
                 int cargoWeight) {
        super(model, weight);
        this.setCargoWeight(cargoWeight);
        this.boatEngine = boatEngine;
    }

    private void setCargoWeight(int cargoWeight) {
        if (cargoWeight<=0){
            throw new IllegalArgumentException(String.format(S_MUST_BE_A_POSITIVE_INTEGER,"Cargo Weight"));
        }
        this.cargoWeight = cargoWeight;
    }

    @Override
    public boolean isMotorBoat() {
        return true;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
        double speed =  this.boatEngine.getOutput() - (this.getWeight() + this.cargoWeight) + (race.getOceanCurrentSpeed() / 2d);
        if (speed<0d){
            return 0d;
        }
        return speed;
    }
}
