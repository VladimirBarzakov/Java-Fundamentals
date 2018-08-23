package models;

public abstract class Car {
    private String brand;
    private String model;
    private int yearOfProduction;
    private int horsepower;
    private int acceleration;
    private int suspension;
    private int durability;

    public Car(String brand,
               String model,
               int yearOfProduction,
               int horsepower,
               int acceleration,
               int suspension,
               int durability) {
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.horsepower = horsepower;
        this.acceleration = acceleration;
        this.suspension = suspension;
        this.durability = durability;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public void setSuspension(int suspension) {
        this.suspension = suspension;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public int getHorsepower() {
        return this.horsepower;
    }

    public int getSuspension() {
        return this.suspension;
    }

    public int getDurability() {
        return this.durability;
    }

    public int getAcceleration() {
        return this.acceleration;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public int getYearOfProduction() {
        return this.yearOfProduction;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s %s %d",this.brand,this.model,this.yearOfProduction))
                .append(System.lineSeparator());
        builder.append(String.format("%d HP, 100 m/h in %d s",this.horsepower,this.acceleration))
                .append(System.lineSeparator());
        builder.append(String.format("%d Suspension force, %d Durability",this.suspension,this.durability));
        return builder.toString();
    }

    public void tune(int tuneIndex, String addOnn){
        this.setHorsepower(this.getHorsepower()+tuneIndex);
        this.setSuspension(this.getSuspension()+tuneIndex/2);
    }
}
