package models;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class Race {
    private int length;
    private String route;
    private int prizePool;
    private Map<Integer,Car> participants;

    public Race(int length, String route, int prizePool) {
        this.length = length;
        this.route = route;
        this.prizePool = prizePool;
        this.participants = new LinkedHashMap<>();
    }

    public int getLength() {
        return this.length;
    }

    public String getRoute() {
        return this.route;
    }

    public int getPrizePool() {
        return this.prizePool;
    }

    public Map<Integer, Car> getParticipants() {
        return this.participants;
    }

    public void addParticipant(int carId, Car car){
        this.participants.put(carId, car);
    }


    protected abstract int getPerformancePoints(Car car);

    public  String race(){
        List<Car> rankedParticipants = this.participants.values().stream().sorted((x,y)->
            this.getPerformancePoints(y)-this.getPerformancePoints(x)).limit(3).collect(Collectors.toList());
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s - %d",this.route,this.length));
        for (int i = 0; i < rankedParticipants.size(); i++) {
            Car car = rankedParticipants.get(i);
            int prize = 0;
            switch (i){
                case 0:
                    prize=(this.prizePool*50)/100;
                    break;
                case 1:
                    prize=(this.prizePool*30)/100;
                    break;
                case 2:
                    prize=(this.prizePool*20)/100;
                    break;
            }
            builder.append(System.lineSeparator()).append(
                    String.format("%d. %s %s %dPP - $%d",i+1,car.getBrand(),car.getModel(),
                            this.getPerformancePoints(car),
                            prize));

        }
        return builder.toString();
    }

}
