package p03_wild_farm.animal;

import p03_wild_farm.food.Food;

public class Mouse extends Mammal{


    public Mouse(String animalType, String animalName, double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    public void eat(Food food)  {
        if (!food.getClass().getSimpleName().equals("Vegetable")){
            throw new IllegalArgumentException(String.format(WRONG_FOOD_EXCEPTION_MESSAGE, "Mice"));
        }
        super.eat(food);
    }

    @Override
    public String makeSound() {
        return "SQUEEEAAAK!";
    }

}
