package models.cells.baseClasses;

public abstract class BloodCell extends Cell {

    public BloodCell(String id, int health, int positionRow, int positionCol) {
        super(id, health, positionRow, positionCol);
    }

    @Override
    public Cell cellEngagement(Cell other) {
        this.setHealth(this.getHealth()+other.getHealth());
        return this;
    }
}
