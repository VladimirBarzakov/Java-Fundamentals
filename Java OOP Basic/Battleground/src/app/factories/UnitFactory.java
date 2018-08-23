package app.factories;

import app.constants.ExceptionMessages;
import app.enums.UnitType;
import app.exceptions.GameException;
import app.exceptions.InvalidUnitException;
import app.handlers.CarrierCombatHandler;
import app.handlers.MarineCombatHandler;
import app.interfaces.gameModels.Position;
import app.interfaces.gameModels.Unit;
import app.models.gameboard.PositionImpl;
import app.models.units.Carrier;
import app.models.units.Marine;

public final class UnitFactory {

    public static final Unit generateUnit(String[] args) throws GameException {
        Unit unit = null;
        try {
            UnitType typeUnit = UnitType.valueOf(args[1].toUpperCase());
            String name = args[2];
            int row = Integer.parseInt(args[3]);
            int col = Integer.parseInt(args[4]);
            Position position = new PositionImpl(row, col);
            switch (typeUnit) {
                case MARINE:
                    return new Marine(name, position, new MarineCombatHandler());
                case CARRIER:
                    return new Carrier(name, position, new CarrierCombatHandler());
            }
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            throw new GameException(ExceptionMessages.UNKNOWN_COMMAND_MESSAGE);
        } catch (IllegalArgumentException e) {
            throw new InvalidUnitException(ExceptionMessages.INVALID_UNIT_TYPE_EXCEPTION_MESSAGE);
        }
        return unit;
    }
}
