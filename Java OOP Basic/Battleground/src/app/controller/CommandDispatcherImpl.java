package app.controller;

import app.commands.*;
import app.constants.ExceptionMessages;
import app.enums.CommandTypes;
import app.exceptions.GameException;
import app.interfaces.gameLogic.Command;
import app.interfaces.gameLogic.CommandDispatcher;
import app.interfaces.gameModels.ActiveRepository;
import app.interfaces.gameModels.Battleground;
import app.interfaces.gameModels.InactiveRepository;
import app.interfaces.gameModels.Unit;

import java.util.HashMap;
import java.util.Map;

public class CommandDispatcherImpl implements CommandDispatcher {

    private Map<String, Command> commands;

    public CommandDispatcherImpl(Battleground battleground,
                                 ActiveRepository<Unit> activeRepository,
                                 InactiveRepository<Unit> killedRepository) {
        this.commands = new HashMap<String, Command>() {{
            put(CommandTypes.GAME_OVER.toString(), new GameOverCommand(battleground, activeRepository, killedRepository));
            put(CommandTypes.FIGHT.toString(), new FightCommand(battleground, activeRepository, killedRepository));
            put(CommandTypes.MOVE.toString(), new MoveCommand(battleground, activeRepository, killedRepository));
            put(CommandTypes.SPAWN.toString(), new SpawnCommand(battleground, activeRepository, killedRepository));
            put(CommandTypes.STATUS.toString(), new StatusCommand(battleground, activeRepository, killedRepository));
        }};
    }


    public String dispatchCommand(String[] args) throws GameException {
        String commandType = args[0];
        if (!this.commands.containsKey(commandType)) {
            return ExceptionMessages.UNKNOWN_COMMAND_MESSAGE;
        }
        String result = this.commands.get(commandType).execute(args);
        return result;
    }
}
