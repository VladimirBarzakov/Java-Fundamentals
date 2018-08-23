package models.cells.baseClasses;


public abstract class Microbe extends Cell {
    private int virulence;
    public Microbe(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol);
        this.virulence=virulence;
    }

    public int getVirulence() {

        return this.virulence;
    }

    @Override
    public Cell cellEngagement(Cell other) {
        while (this.getHealth()>0 && other.getHealth()>0){
            other.setHealth(other.getHealth()-this.getEnergy());
            if (other.getHealth()<=0){
                return this;
            }

            this.setHealth(this.getHealth()-other.getEnergy());
            if (this.getHealth()<=0){
                return other;
            }
        }
        return null;
    }

    @Override
    public String toString() {

        return super.toString()+System.lineSeparator()+
                String.format("--------Health: %d | Virulence: %d | Energy: %d",
                super.getHealth(),
                this.getVirulence(),
                this.getEnergy());
    }
}
