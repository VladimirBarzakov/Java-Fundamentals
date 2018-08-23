package p05_speed_racing;

import java.util.HashSet;
import java.util.Set;

public class Car {

    private static Set<String> carModels = new HashSet<>();

    private String model;
    private double fuelAmount;
    private double fuelConsumptionPerKilometer;
    private long distanceTraveled;

    public Car() {
    }

    public Car(String model, double fuelAmount, double fuelConsumptionPerKilometer) throws IllegalArgumentException {
        if (carModels.contains(model)){
            throw new IllegalArgumentException("p05_speed_racing.p06_raw_data.p07_car_salesman.p09_google.Car with this model already exist");
        }
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelConsumptionPerKilometer = fuelConsumptionPerKilometer;
        this.distanceTraveled=0;
    }

    public boolean canTravelDistance(long distance){
        return distance*this.fuelConsumptionPerKilometer<=this.fuelAmount;
    }

    public void travel(long distance){
        if (canTravelDistance(distance)){
            this.distanceTraveled+=distance;
            this.fuelAmount-=distance*this.fuelConsumptionPerKilometer;
        }
    }

    public String getModel() {
        return model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getFuelConsumptionPerKilometer() {
        return fuelConsumptionPerKilometer;
    }

    public long getDistanceTraveled() {
        return distanceTraveled;
    }


    @Override
    public String toString() {
        return String.format("%s %.2f %d",this.model,this.fuelAmount,this.distanceTraveled);
    }
}
