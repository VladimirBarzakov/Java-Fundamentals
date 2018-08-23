package app.commands;

import app.interfaces.gameModels.ActiveRepository;
import app.interfaces.gameModels.Battleground;
import app.interfaces.gameModels.InactiveRepository;
import app.interfaces.gameModels.Unit;

public abstract class BaseCommand {
    private Battleground battleground;
    private ActiveRepository<Unit> activeRepository;
    private InactiveRepository<Unit> killedRepository;

    protected BaseCommand(Battleground battleground,
                          ActiveRepository<Unit> activeUnitRepository,
                          InactiveRepository<Unit> killedUnitRepository) {
        this.battleground = battleground;
        this.activeRepository = activeUnitRepository;
        this.killedRepository = killedUnitRepository;
    }

    public void setBattleground(Battleground battleground) {
        if (this.battleground == null) {
            this.battleground = battleground;
        }
    }

    protected Battleground getBattleground() {
        return this.battleground;
    }

    protected ActiveRepository<Unit> getActiveRepository() {
        return this.activeRepository;
    }

    protected InactiveRepository<Unit> getKilledRepository() {
        return this.killedRepository;
    }
}
