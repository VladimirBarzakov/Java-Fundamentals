package app.entities.baseEntitties;

import app.constants.ExceptionMessages;
import app.contracts.SuperPower;

import java.util.ArrayList;
import java.util.List;

public abstract class ComicCharacterImpl {
    private String name;
    private int energy;
    private double health;
    private  double intelligence;
    private List<SuperPower> powers;

    public ComicCharacterImpl(String name, int energy, double health, double intelligence) {
        this.setName(name);
        this.setEnergy(energy);
        this.setHealth(health);
        this.setIntelligence(intelligence);
        this.powers=new ArrayList<>();
    }

    private void setName(String name) {
        if (!name.matches("^[A-Za-z_]{2,12}$")){
            throw new IllegalArgumentException(ExceptionMessages.ILLEGAL_CHARACTER_NAME_MESSAGE);
        }
        this.name = name;
    }


    private void setEnergy(int energy) {
        if (energy<0 || energy>300){
            throw new IllegalArgumentException(ExceptionMessages.ILLEGAL_CHARACTER_ENERGY_MESSAGE);
        }
        this.energy = energy;
    }

    private void setHealth(double health) {
        if (health<0){
            throw new IllegalArgumentException(ExceptionMessages.ILLEGAL_CHARACTER_HEALTH_MESSAGE);
        }
        this.health = health;
    }

    private void setIntelligence(double intelligence) {
        if (intelligence<0 || intelligence>200){
            throw new IllegalArgumentException(ExceptionMessages.ILLEGAL_CHARACTER_INTELLIGENCE_MESSAGE);
        }
        this.intelligence = intelligence;
    }

    public void takeDamage(double damage){
        this.health-= damage;
    }

    public void  boostCharacter(int energy,double health,double inteligence){
        this.setEnergy(energy);
        this.setHealth(health);
        this.setIntelligence(intelligence);
    }

    public String getName() {
        return this.name;
    }

    public int getEnergy() {
        return this.energy;
    }

    public double getHealth() {

        return this.health;
    }

    public double getIntelligence() {

        return this.intelligence;
    }

    public String useSuperPowers(){
        if (this.powers.size()==0){
            return String.format("%s has no super powers!",this.name);
        }
        for (SuperPower power:this.powers) {
            this.setEnergy(this.getEnergy()+(int)power.getPowerPoints());
            this.setHealth(this.getHealth()+power.getPowerPoints()*2);
        }
        return String.format("%s used his super powers!",this.name);
    }

    public void addSuperPower(SuperPower superPower){
        this.powers.add(superPower);
    }

    @Override
    public String toString() {
        return String.format("#Name: %s%n##Health: %.2f// Energy: %d// Intelligence: %.2f",
                this.name, this.health,this.energy,this.intelligence);
    }
}
