package models;

import models.cells.baseClasses.Cell;

import java.util.Arrays;
import java.util.Objects;

public class Cluster {
    private String id;
    private int rows;
    private int cols;
    private Cell[][] cells;
    private int cellSize;

    public Cluster(String id, int rows, int cols) {
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.cells=new Cell[rows][cols];
        this.cellSize=0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("----Cluster %s",this.id));
        Arrays.stream(this.cells).forEach(x-> Arrays.stream(x)
                .filter(Objects::nonNull)
                .forEach(c->builder.append(System.lineSeparator()).append(c.toString())));
        return builder.toString();
    }

    public int getCellSize() {

        return this.cellSize;
    }

    public void setCellSize(int cellSize) {
        this.cellSize = cellSize;
    }

    public String getName() {
        return this.id;
    }

    public Cell[][] getCells() {
        return this.cells;
    }
}
