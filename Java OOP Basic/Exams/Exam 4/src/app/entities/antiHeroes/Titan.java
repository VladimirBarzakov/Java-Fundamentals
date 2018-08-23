package app.entities.antiHeroes;

import app.contracts.ComicCharacter;
import app.entities.baseEntitties.AntiHero;

public class Titan extends AntiHero implements ComicCharacter {
    public Titan(String name, int energy, double health, double intelligence, double evilness) {
        super(name, energy, health, intelligence, evilness);
    }


    public double attack() {
        return (super.getEnergy()+super.getIntelligence()+this.getSpecial())*3;
    }

    @Override
    public String toString() {
        return String.format("%s%n####Titan Attack Power: %.2f",super.toString(),this.attack());
    }
}
