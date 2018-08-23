package app.entities;

import app.constants.ExceptionMessages;
import app.contracts.SuperPower;

public class Power implements SuperPower {
    private String name;
    private double powerPoints;

    public Power(String name, double powerPoints) {
        this.setName(name);
        this.setPowerPoints(powerPoints);
    }

    private void setName(String name) {
        if (!name.matches("^@[A-Za-z_]{3,}@$")){
            throw new IllegalArgumentException(ExceptionMessages.ILLEGAL_POWER_NAME_MESSAGE);
        }
        this.name = name;
    }

    private void setPowerPoints(double powerPoints) {
        if (powerPoints<0){
            throw new IllegalArgumentException(ExceptionMessages.ILLEGAL_POWER_POWERPOINTS_MESSAGE);
        }
        this.powerPoints = powerPoints;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPowerPoints() {
        return this.powerPoints+this.name.length()/2;
    }

    @Override
    public String toString() {
        return "Power{" +
                "name='" + name + '\'' +
                ", powerPoints=" + powerPoints +
                '}';
    }
}
