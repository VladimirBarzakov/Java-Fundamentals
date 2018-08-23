package models.cars;

import models.Car;

public class ShowCar extends Car {

    private int stars = 0;
    public ShowCar(String brand, String model, int yearOfProduction, int horsepower,
                   int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() +
                String.format("%d *", this.stars);
    }

    @Override
    public void tune(int tuneIndex, String addOnn) {
        super.tune(tuneIndex,addOnn);
        this.stars+=tuneIndex;
    }
}
