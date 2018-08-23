package models.races;

import models.Car;
import models.Race;

public class DragRace extends Race {
    public DragRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }


    @Override
    protected int getPerformancePoints(Car car) {
        return car.getHorsepower()/car.getAcceleration();
    }


}
