package app.commands;

import app.constants.ExceptionMessages;
import app.constants.GameMessages;
import app.exceptions.GameException;
import app.interfaces.gameLogic.Command;
import app.interfaces.gameModels.*;
import app.models.gameboard.PositionImpl;

public class MoveCommand extends BaseCommand implements Command {


    public MoveCommand(Battleground battleground,
                       ActiveRepository<Unit> activeUnitRepository,
                       InactiveRepository<Unit> killedUnitRepository) {
        super(battleground, activeUnitRepository, killedUnitRepository);
    }

    @Override
    public String execute(String[] args) {
        String result = "";
        try {
            String unitName = args[1];
            int targetRow = Integer.parseInt(args[2]);
            int targetColumn = Integer.parseInt(args[3]);

            Unit unit = super.getActiveRepository().getEntity(unitName);
            Position position = new PositionImpl(targetRow, targetColumn);
            super.getBattleground().move(unit, position);
            result = String.format(GameMessages.SUCCESSFUL_MOVE_COMMAND_MESSAGE, unit.getName(), targetRow, targetColumn);
        } catch (GameException e) {
            return e.getMessage();
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            return ExceptionMessages.UNKNOWN_COMMAND_MESSAGE;
        }
        return result;
    }
}
