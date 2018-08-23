package models.races;

import models.Car;
import models.Race;

import java.util.List;
import java.util.stream.Collectors;

public class CircuitRace extends Race {
    private int laps;

    public CircuitRace(int length, String route, int prizePool, int laps) {
        super(length, route, prizePool);
        this.laps = laps;
    }

    @Override
    protected int getPerformancePoints(Car car) {
        return (car.getHorsepower()/car.getAcceleration())+(car.getSuspension()+car.getDurability());
    }

    @Override
    public  String race(){
        List<Car> rankedParticipants = super.getParticipants().values()
                .stream().sorted((x, y)->
                    this.getPerformancePoints(y)-this.getPerformancePoints(x))
                .limit(4).collect(Collectors.toList());

        int totalDurabilityDamage = super.getLength()*super.getLength()*this.laps;

        super.getParticipants().values().forEach(x->x.setDurability(x.getDurability()-totalDurabilityDamage));

        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s - %d",super.getRoute(),this.getLength()*this.laps));
        for (int i = 0; i < rankedParticipants.size(); i++) {
            Car car = rankedParticipants.get(i);
            int prize = 0;
            switch (i){
                case 0:
                    prize=(super.getPrizePool()*40)/100;
                    break;
                case 1:
                    prize=(super.getPrizePool()*30)/100;
                    break;
                case 2:
                    prize=(super.getPrizePool()*20)/100;
                    break;
                case 3:
                    prize=(super.getPrizePool()*10)/100;
                    break;
            }
            builder.append(System.lineSeparator()).append(
                    String.format("%d. %s %s %dPP - $%d",
                            i+1,
                            car.getBrand(),car.getModel(),
                            this.getPerformancePoints(car),
                            prize));

        }
        return builder.toString();
    }
}
