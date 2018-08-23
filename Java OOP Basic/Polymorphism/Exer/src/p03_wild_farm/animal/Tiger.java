package p03_wild_farm.animal;

import p03_wild_farm.food.Food;

public class Tiger extends Feline {


    public Tiger(String animalType, String animalName, double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    public void eat(Food food) {
        if (!food.getClass().getSimpleName().equals("Meat")){
            throw new IllegalArgumentException(String.format(WRONG_FOOD_EXCEPTION_MESSAGE, "Tigers"));
        }
        super.eat(food);
    }

    @Override
    public String makeSound() {
        return "ROAAR!!!";
    }
}
