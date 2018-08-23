package p03_wild_farm.animal;

public class Cat extends Feline {
    private String breed;

    public Cat(String animalType, String animalName, double animalWeight, String livingRegion, String breed) {
        super(animalType, animalName, animalWeight, livingRegion);
        this.breed=breed;
    }

    @Override
    public String makeSound() {
        return "Meowwww";
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %s, %d]",
                this.getAnimalType(),
                this.getAnimalName(),
                this.breed,
                DECIMAL_FORMAT.format(this.getAnimalWeight()),
                this.getLivingRegion(),
                this.getFoodEaten());
    }
}
