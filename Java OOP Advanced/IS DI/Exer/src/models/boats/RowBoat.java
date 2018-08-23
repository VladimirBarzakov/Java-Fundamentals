package models.boats;

import contracts.Race;

import static utility.Constants.S_MUST_BE_A_POSITIVE_INTEGER;

public class RowBoat extends BaseBoat {
    private int oars;

    public RowBoat(String model, int weight, int oars) {
        super(model, weight);
        this.setOars(oars);
    }

    private void setOars(int oars) {
        if (oars<=0){
            throw new IllegalArgumentException(String.format(S_MUST_BE_A_POSITIVE_INTEGER,"Oars"));
        }
        this.oars = oars;
    }

    @Override
    public boolean isMotorBoat() {
        return false;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
       double speed =  (this.oars * 100d) - this.getWeight() + race.getOceanCurrentSpeed();
        if (speed<0d){
            return 0d;
        }
        return speed;
    }
}
