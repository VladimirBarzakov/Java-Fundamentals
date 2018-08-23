package models.cars;

import models.Car;

import java.util.ArrayList;
import java.util.List;

public class PerformanceCar extends Car {
    private List<String> addOns;

    public PerformanceCar(String brand, String model, int yearOfProduction,
                          int horsepower, int acceleration, int suspension,
                          int durability) {
        super(brand, model, yearOfProduction,
                horsepower+(horsepower*50)/100
                ,acceleration,
                suspension-(suspension*25)/100,
                durability);
        this.addOns=new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString()).append(System.lineSeparator());
        builder.append("Add-ons: ");
        if (this.addOns.size()==0){
            builder.append("None");
        } else{
            builder.append(this.addOns.toString().replaceAll("[\\[\\]]",""));
        }
        return builder.toString();
    }

    @Override
    public void tune(int tuneIndex, String addOnn) {
        super.tune(tuneIndex,addOnn);

        this.addOns.add(addOnn);
    }
}
