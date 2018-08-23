package p03_wild_farm.animal;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal{
    protected static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");
    protected static final String WRONG_FOOD_EXCEPTION_MESSAGE = "%s are not eating that type of p03_wild_farm.food!";

    private String livingRegion;

    public Mammal(String animalType, String animalName, double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight);
        this.livingRegion = livingRegion;
    }

    protected String getLivingRegion() {
        return this.livingRegion;
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %d]",
                this.getAnimalType(),
                this.getAnimalName(),
                DECIMAL_FORMAT.format(this.getAnimalWeight()),
                this.livingRegion,
                this.getFoodEaten());
    }
}
