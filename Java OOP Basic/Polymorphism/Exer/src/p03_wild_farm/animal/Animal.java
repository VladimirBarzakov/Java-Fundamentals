package p03_wild_farm.animal;

import p03_wild_farm.food.Food;

public abstract class Animal {

    private String animalName;
    private String animalType;
    private double animalWeight;
    private long foodEaten;

    protected Animal(String animalType, String animalName, double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten=0;
    }

    protected String getAnimalName() {
        return this.animalName;
    }

    protected String getAnimalType() {
        return this.animalType;
    }

    protected double getAnimalWeight() {
        return this.animalWeight;
    }

    protected long getFoodEaten() {
        return this.foodEaten;
    }

    public abstract String makeSound();

    public void eat(Food food) {
        this.foodEaten+=food.getQuantity();
    };


}
