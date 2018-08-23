package models.cells.boodCells;

import models.cells.baseClasses.BloodCell;

public class RedBloodCell extends BloodCell {
    private int velocity;

    public RedBloodCell(String id, int health, int positionRow, int positionCol, int velocity) {
        super(id, health, positionRow, positionCol);
        this.velocity=velocity;
    }

    public int getVelocity() {
        return this.velocity;
    }

    public int getEnergy(){
        return super.getHealth()+this.velocity;
    }

    @Override
    public String toString() {
        return super.toString()+System.lineSeparator()+
                String.format("--------Health: %d | Velocity: %d | Energy: %d",
                this.getHealth(),
                this.getVelocity(),
                this.getEnergy());
    }
}
