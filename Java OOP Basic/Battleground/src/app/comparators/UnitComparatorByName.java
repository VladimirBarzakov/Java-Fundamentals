package app.comparators;

import app.interfaces.gameModels.Unit;

import java.util.Comparator;

public class UnitComparatorByName implements Comparator<Unit> {

    public UnitComparatorByName() {
    }

    @Override
    public int compare(Unit unit1, Unit unit2) {
        return unit1.getName().compareTo(unit2.getName());
    }
}
