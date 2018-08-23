package app.models.units;

import app.constants.unitsParams.CarrierParams;
import app.enums.UnitType;
import app.interfaces.gameLogic.CombatHandler;
import app.interfaces.gameModels.Position;
import app.interfaces.gameModels.Unit;

public class Carrier extends BaseUnit implements Unit {

    public Carrier(String name,
                   Position position, CombatHandler combatHandler) {
        super(name,
                CarrierParams.RANGE,
                position,
                CarrierParams.HEALTH_POINTS,
                CarrierParams.ENERGY_POINTS,
                CarrierParams.ATTACK_POINTS,
                CarrierParams.DEFENCE_POINTS,
                combatHandler);


    }

    @Override
    public String toString() {
        String result = "->" + super.getName() + System.lineSeparator() +
                "- Type: " + UnitType.CARRIER.toString() +
                System.lineSeparator() +
                super.toString();
        return result;
    }
}
