package models.cells.baseClasses;

public abstract class Cell {
    private String id;
    private int health;
    private int positionRow;
    private int positionCol;

    public Cell(String id, int health, int positionRow, int positionCol) {
        this.id = id;
        this.health = health;
        this.positionRow = positionRow;
        this.positionCol = positionCol;
    }

    public int getHealth() {
        return this.health;
    }

    public int getPositionRow() {
        return this.positionRow;
    }

    public int getPositionCol() {
        return this.positionCol;
    }

    public int getEnergy(){
        return 0;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setPositionRow(int positionRow) {
        this.positionRow = positionRow;
    }

    public void setPositionCol(int positionCol) {
        this.positionCol = positionCol;
    }

    @Override
    public String toString() {
        return String.format("------Cell %s [%d,%d]",
                this.id,
                this.positionRow,
                this.positionCol);
    }

    public Cell cellEngagement(Cell other){
        return null;
    }
}
