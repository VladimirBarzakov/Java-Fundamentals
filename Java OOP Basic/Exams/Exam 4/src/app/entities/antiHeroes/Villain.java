package app.entities.antiHeroes;

import app.contracts.ComicCharacter;
import app.entities.baseEntitties.AntiHero;

public class Villain extends AntiHero implements ComicCharacter {

    public Villain(String name, int energy, double health, double intelligence, double evilness) {
        super(name, energy, health, intelligence, evilness);
    }


    public double attack() {
        return (super.getIntelligence()*this.getSpecial())/super.getEnergy();
    }

    @Override
    public String toString() {
        return String.format("%s%n####Villain Attack Power: %.2f",super.toString(),this.attack());
    }
}
