package models.races;

import models.Car;
import models.Race;

public class TimeLimitRace extends Race {

    private int goldTime;

    public TimeLimitRace(int length, String route, int prizePool, int goldTime) {
        super(length, route, prizePool);
        this.goldTime = goldTime;
    }

    @Override
    public void addParticipant(int carId, Car car) {
        if (super.getParticipants().size()<1){
            super.addParticipant(carId, car);
        }
    }

    @Override
    protected int getPerformancePoints(Car car) {
        return super.getLength()*((car.getHorsepower()/100)*car.getAcceleration());
    }

    @Override
    public String race() {
        Car car = super.getParticipants().values().stream().findFirst().get();
        int prize = 0;
        int carTimePerformance = this.getPerformancePoints(car);
        String earnTime = "";
        if (carTimePerformance<=this.goldTime){
            prize=super.getPrizePool();
            earnTime="Gold";
        } else if(carTimePerformance<=this.goldTime+15){
            prize=super.getPrizePool()/2;
            earnTime="Silver";
        } else{
            prize=(super.getPrizePool()*30)/100;
            earnTime="Bronze";
        }
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s - %d",super.getRoute(),super.getLength())).append(System.lineSeparator());
        builder.append(String.format("%s %s - %d s.",car.getBrand(), car.getModel(),carTimePerformance)).append(System.lineSeparator());
        builder.append(String.format("%s Time, $%d.",earnTime,prize));
        return builder.toString();
    }
}
