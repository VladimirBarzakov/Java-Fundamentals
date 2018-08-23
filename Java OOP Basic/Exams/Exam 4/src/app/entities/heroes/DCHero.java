package app.entities.heroes;

import app.contracts.ComicCharacter;
import app.entities.baseEntitties.Hero;

public class DCHero extends Hero implements ComicCharacter {
    public DCHero(String name, int energy, double health, double intelligence, double heroism) {
        super(name, energy, health, intelligence, heroism);
    }


    public double attack() {
        return (super.getEnergy()/1.5)+this.getSpecial()+super.getIntelligence();
    }

    @Override
    public String toString() {
        return String.format("%s%n####DC Attack Power: %.2f",super.toString(),this.attack());
    }
}
