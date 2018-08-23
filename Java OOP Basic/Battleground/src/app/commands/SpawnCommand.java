package app.commands;

import app.constants.GameMessages;
import app.exceptions.GameException;
import app.exceptions.IllegalPositionException;
import app.exceptions.InvalidPositionException;
import app.exceptions.InvalidUnitException;
import app.factories.UnitFactory;
import app.interfaces.gameModels.*;
import app.interfaces.gameLogic.Command;

public class SpawnCommand extends BaseCommand implements Command {

    public SpawnCommand(Battleground battleground,
                        ActiveRepository<Unit> activeUnitRepository,
                        InactiveRepository<Unit> killedUnitRepository) {
        super(battleground, activeUnitRepository, killedUnitRepository);
    }

    @Override
    public String execute(String[] args) {
        String result = "";
        Unit unit = null;
        try {
            unit = UnitFactory.generateUnit(args);
            super.getActiveRepository().save(unit);
            super.getBattleground().add(unit);
            result = String.format(GameMessages.SUCCESSFUL_SPAWN_MESSAGE,
                    unit.getName(),
                    args[1],
                    unit.getPosition().getX(),
                    unit.getPosition().getY());
        } catch (InvalidPositionException e) {
            return e.getMessage();
        } catch (IllegalPositionException e) {
            try {
                super.getActiveRepository().remove(unit);
            } catch (InvalidUnitException e1) {
                ;
            }
            return e.getMessage();
        } catch (GameException e) {
            return e.getMessage();
        }
        return result;
    }
}
