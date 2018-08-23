package app.entities.heroes;

import app.contracts.ComicCharacter;
import app.entities.baseEntitties.Hero;

public class MarvelHero extends Hero implements ComicCharacter {
    public MarvelHero(String name, int energy, double health, double intelligence, double heroism) {
        super(name, energy, health, intelligence, heroism);
    }


    public double attack() {
        return ((super.getEnergy()+ this.getSpecial())*super.getIntelligence())/2.5;
    }

    @Override
    public String toString() {
        return String.format("%s%n####Marvel Attack Power: %.2f",super.toString(),this.attack());
    }
}
