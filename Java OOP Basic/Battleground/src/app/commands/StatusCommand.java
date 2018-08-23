package app.commands;

import app.exceptions.InvalidUnitException;
import app.interfaces.gameLogic.Command;
import app.interfaces.gameModels.ActiveRepository;
import app.interfaces.gameModels.Battleground;
import app.interfaces.gameModels.InactiveRepository;
import app.interfaces.gameModels.Unit;

public class StatusCommand extends BaseCommand implements Command {
    public StatusCommand(Battleground battleground,
                         ActiveRepository<Unit> activeUnitRepository,
                         InactiveRepository<Unit> killedUnitRepository) {
        super(battleground, activeUnitRepository, killedUnitRepository);
    }

    @Override
    public String execute(String[] args) {
        String name = args[1];
        Unit unit;
        try {
            unit = super.getActiveRepository().getEntity(name);
        } catch (InvalidUnitException e) {
            return e.getMessage();
        }
        return unit.toString();
    }
}
