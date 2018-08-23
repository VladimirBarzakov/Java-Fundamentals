package app.models.units;

import app.constants.unitsParams.MarineParams;
import app.enums.UnitType;
import app.interfaces.gameLogic.CombatHandler;
import app.interfaces.gameModels.Position;
import app.interfaces.gameModels.Unit;

public class Marine extends BaseUnit implements Unit {

    public Marine(String name,
                  Position position, CombatHandler combatHandler) {
        super(  name,
                MarineParams.RANGE,
                position,
                MarineParams.HEALTH_POINTS,
                MarineParams.ENERGY_POINTS,
                MarineParams.ATTACK_POINTS,
                MarineParams.DEFENCE_POINTS,
                combatHandler);
    }

    @Override
    public String toString() {
        String result =
                "->" + super.getName() + System.lineSeparator() +
                "- Type: " + UnitType.MARINE.toString() +
                System.lineSeparator() +
                super.toString();
        return result;
    }
}
