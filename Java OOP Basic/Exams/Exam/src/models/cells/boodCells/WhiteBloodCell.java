package models.cells.boodCells;

import models.cells.baseClasses.BloodCell;

public class WhiteBloodCell extends BloodCell {
    private int size;

    public WhiteBloodCell(String id, int health, int positionRow, int positionCol, int size) {
        super(id, health, positionRow, positionCol);
        this.size=size;
    }

    public int getSize() {
        return this.size;
    }

    public int getEnergy(){
        return (super.getHealth()+this.size)*2;
    }

    @Override
    public String toString() {
        return super.toString()+System.lineSeparator()+
                String.format("--------Health: %d | Size: %d | Energy: %d",
                this.getHealth(),
                this.getSize(),
                this.getEnergy());
    }
}
