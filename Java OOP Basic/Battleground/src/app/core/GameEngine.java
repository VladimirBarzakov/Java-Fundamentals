package app.core;

import app.battleGround.BattleGroundImpl;
import app.constants.GameConstants;
import app.constants.GameMessages;
import app.controller.CommandDispatcherImpl;
import app.exceptions.GameException;
import app.interfaces.core.Engine;
import app.interfaces.core.InputReader;
import app.interfaces.core.OutputWriter;
import app.interfaces.gameModels.ActiveRepository;
import app.interfaces.gameLogic.CommandDispatcher;
import app.interfaces.gameModels.Battleground;
import app.interfaces.gameModels.InactiveRepository;
import app.interfaces.gameModels.Unit;
import app.io.InputReaderImpl;
import app.io.OutputWriterImpl;
import app.repository.ActiveUnitRepository;
import app.repository.KilledUnitRepository;

import java.io.IOException;

public class GameEngine implements Engine {

    private InputReader inputReader;
    private OutputWriter outputWriter;
    private CommandDispatcher commandDispatcher;
    private boolean isStarted;
    private Battleground battleground;
    private ActiveRepository<Unit> activeRepository;
    private InactiveRepository<Unit> inactiveRepository;

    public GameEngine() {
        if (isStarted) {
            throw new IllegalArgumentException("Game engine has already stared!");
        }
        this.outputWriter = new OutputWriterImpl();
        this.inputReader = new InputReaderImpl();
        this.activeRepository = new ActiveUnitRepository();
        this.inactiveRepository = new KilledUnitRepository();
        this.battleground = null;
        this.commandDispatcher = null;
        this.isStarted = true;
    }

    public void setBattleground(Battleground battleground) {
        if (this.battleground == null) {
            this.battleground = battleground;
        }
    }

    public void start() {

        while (isStarted) {
            try {
                String result;
                String userInput;
                String[] args;
                //First initialise BattleGround
                if (this.battleground == null) {
                    this.outputWriter.writeLine(GameMessages.INITIALISE_BATTLEGROUND_MESSAGE);
                    userInput = this.inputReader.readLine();
                    args = userInput.split("\\s+");
                    result = initialiseBattleGroundAndCommandDispatcher(args);
                } else {
                    this.outputWriter.writeLine(this.battleground.toString());
                    this.outputWriter.writeLine(GameMessages.ENTER_YOUR_COMMAND_MESSAGE);
                    userInput = this.inputReader.readLine();
                    args = userInput.split("\\s+");
                    result = this.commandDispatcher.dispatchCommand(args);
                }
                if (result != null) {
                    this.outputWriter.writeLine(result);
                    //When Stop command is received...
                    if (result.split(System.lineSeparator())[0].equals(GameMessages.GAME_OVER_MESSAGE)) {
                        isStarted = false;
                    }
                }

            } catch (GameException | IOException e) {
                this.outputWriter.writeLine(e.getMessage());
                this.outputWriter.writeLine(this.battleground.toString());
            }
        }
    }

    private String initialiseBattleGroundAndCommandDispatcher(String[] args) {
        int rows = Integer.parseInt(args[0]);
        int cols = Integer.parseInt(args[1]);
        GameConstants.setBoardSizeRows(rows);
        GameConstants.setBoardSizeCols(cols);
        this.battleground = new BattleGroundImpl();
        this.commandDispatcher = new CommandDispatcherImpl(this.battleground, this.activeRepository, this.inactiveRepository);
        return String.format(GameMessages.SUCCESSFUL_BATTLEGROUND_INITIALISE_MESSAGE, rows, cols);
    }
}
