package app.entities.baseEntitties;

import app.constants.ExceptionMessages;

public abstract class Hero extends ComicCharacterImpl {
    private double heroism;

    public Hero(String name, int energy, double health, double intelligence, double heroism) {
        super(name, energy, health, intelligence);
        this.setHeroism(heroism);
    }

    private void setHeroism(double heroism) {
        if (heroism<0){
            throw new IllegalArgumentException(ExceptionMessages.ILLEGAL_HERO_HEROISM_MESSAGE);
        }
        this.heroism = heroism;
    }


    public double getSpecial(){
        return this.heroism;
    }

    @Override
    public String toString() {
        return String.format("%s%n###Heroism: %.2f",super.toString(),this.heroism);
    }
}
