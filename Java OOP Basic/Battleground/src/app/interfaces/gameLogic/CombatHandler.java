package app.interfaces.gameLogic;

import app.interfaces.gameModels.Spell;
import app.interfaces.gameModels.Unit;

import java.util.List;

public interface CombatHandler {

    void setUnit(Unit unit);

    Unit pickNextTarget(List<Unit> targetCandidates);

    Spell generateAttack();
}
