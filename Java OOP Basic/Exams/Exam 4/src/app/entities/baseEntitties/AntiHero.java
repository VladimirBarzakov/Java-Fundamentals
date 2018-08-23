package app.entities.baseEntitties;

import app.constants.ExceptionMessages;


public abstract class AntiHero extends ComicCharacterImpl {
    private double evilness;

    public AntiHero(String name, int energy, double health, double intelligence, double evilness) {
        super(name, energy, health, intelligence);
        this.setEvilness(evilness);
    }

    public void setEvilness(double evilness) {
        if (evilness<0){
            throw new IllegalArgumentException(ExceptionMessages.ILLEGAL_ANTIHERO_EVILNESS_MESSAGE);
        }
        this.evilness = evilness;
    }

    public double getSpecial(){
        return this.evilness;
    }

    @Override
    public String toString() {
        return String.format("%s%n###Evilness: %.2f",super.toString(),this.evilness);
    }
}
