package app.handlers;

import app.comparators.UnitComparatorByHealthPoints;
import app.comparators.UnitComparatorByName;
import app.interfaces.gameLogic.CombatHandler;
import app.interfaces.gameModels.Unit;

import java.util.List;
import java.util.Optional;

public abstract class CombatHandlerImpl implements CombatHandler {
    private Unit unit;

    protected CombatHandlerImpl() {
    }

    @Override
    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public Unit pickNextTarget(List<Unit> targetCandidates) {

        Optional<Unit> target = targetCandidates.stream().min(
                new UnitComparatorByHealthPoints().thenComparing(new UnitComparatorByName()));
        return target.orElse(null);
    }

    protected Unit getUnit() {
        return this.unit;
    }

}
