package p01to02_vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    protected static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.##");

    private double fuelQuantity;
    private double fuelConsumption;
    private double fuelTankCapacity;
    private double distanceTravelled;


    protected Vehicle(double fuelQuantity, double fuelConsumption, double fuelTankCapacity) {
        this.setFuelTankCapacity(fuelTankCapacity);
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
        this.distanceTravelled=0;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity<0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        } else if (fuelQuantity>this.fuelTankCapacity){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.fuelQuantity = fuelQuantity;
    }

    protected double getFuelQuantity() {
        return this.fuelQuantity;
    }

    public double getDistanceTravelled() {
        return this.distanceTravelled;
    }

    protected void setDistanceTravelled(double distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    private void setFuelTankCapacity(double fuelTankCapacity) {
        this.fuelTankCapacity = fuelTankCapacity;
    }

    public double getFuelConsumption() {
        return this.fuelConsumption;
    }

    protected void refuel(double fuelQuantity) {
        if (fuelQuantity<=0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        setFuelQuantity(getFuelQuantity()+fuelQuantity);
    }

    protected boolean isDistanceDrivable(double distance){
        return this.fuelConsumption*distance<=this.fuelQuantity;
    }

    protected void drive(double distance){
        this.setFuelQuantity(this.fuelQuantity-distance*this.fuelConsumption);
        this.distanceTravelled+=distance;
    }

    public abstract void printFuelQuantity();
}
