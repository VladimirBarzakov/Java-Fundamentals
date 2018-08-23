package app.commands;

import app.constants.GameMessages;
import app.interfaces.gameLogic.Command;
import app.interfaces.gameModels.ActiveRepository;
import app.interfaces.gameModels.Battleground;
import app.interfaces.gameModels.InactiveRepository;
import app.interfaces.gameModels.Unit;

public class GameOverCommand extends BaseCommand implements Command {

    public GameOverCommand(Battleground battleground,
                           ActiveRepository<Unit> activeUnitRepository,
                           InactiveRepository<Unit> killedUnitRepository) {
        super(battleground, activeUnitRepository, killedUnitRepository);
    }

    @Override
    public String execute(String[] args) {
        StringBuilder builder = new StringBuilder();
        builder.append(GameMessages.GAME_OVER_MESSAGE).append(System.lineSeparator());
        builder.append("Units left alive:").append(System.lineSeparator());
        for (Unit unit : super.getActiveRepository().findAll()) {
            builder.append(unit.toString()).append(System.lineSeparator());
        }
        builder.append("Killed units:").append(System.lineSeparator());
        for (Unit unit : super.getKilledRepository().getAll()) {
            builder.append(unit.toString()).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
