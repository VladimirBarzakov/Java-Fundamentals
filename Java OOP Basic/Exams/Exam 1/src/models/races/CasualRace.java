package models.races;

import models.Car;
import models.Race;

public class CasualRace extends Race {
    public CasualRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    protected int getPerformancePoints(Car car) {
        return (car.getHorsepower()/car.getAcceleration())+(car.getSuspension()+car.getDurability());
    }

}
