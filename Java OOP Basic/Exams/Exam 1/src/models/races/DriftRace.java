package models.races;

import models.Car;
import models.Race;



public class DriftRace extends Race {
    public DriftRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }


    @Override
    protected int getPerformancePoints(Car car) {
        return car.getSuspension()+car.getDurability();
    }


}
