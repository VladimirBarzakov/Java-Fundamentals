package models.cells.microbes;

import models.cells.baseClasses.Microbe;

public class Fungi extends Microbe {
    public Fungi(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol, virulence);
    }

    public int getEnergy(){
        return (super.getHealth()+super.getVirulence())/4;
    }
}
