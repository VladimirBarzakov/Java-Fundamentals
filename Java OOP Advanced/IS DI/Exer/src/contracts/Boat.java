package contracts;

public interface Boat extends Modelable{
    boolean isMotorBoat();
    double calculateRaceSpeed(Race race);
}
