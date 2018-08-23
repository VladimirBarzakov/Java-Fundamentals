package app.interfaces.gameLogic;

import app.exceptions.GameException;

public interface CommandDispatcher {
    String dispatchCommand(String[] args) throws GameException;
}
