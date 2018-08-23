package app.comparators;

import app.interfaces.gameModels.Unit;

import java.util.Comparator;

public class UnitComparatorByHealthPoints implements Comparator<Unit> {
    public UnitComparatorByHealthPoints() {
    }

    @Override
    public int compare(Unit unitA, Unit unitB) {
        return unitA.getHealthPoints() - unitB.getHealthPoints();
    }
}
