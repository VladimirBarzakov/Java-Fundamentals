package app.models.gameboard;

import app.constants.ExceptionMessages;
import app.constants.GameConstants;
import app.constants.GameMessages;
import app.exceptions.InvalidPositionException;
import app.interfaces.gameModels.Position;

public class PositionImpl implements Position {
    private int x;
    private int y;

    public PositionImpl(int x, int y) throws InvalidPositionException {
        this.setX(x);
        this.setY(y);
    }

    private void setX(int x) throws InvalidPositionException {
        if (x < 0 || x >= GameConstants.getBoardSizeRows()) {
            throw new InvalidPositionException(ExceptionMessages.INVALID_COORDINATES_EXCEPTION_MESSAGE);
        }
        this.x = x;
    }

    private void setY(int y) throws InvalidPositionException {
        if (y < 0 || y >= GameConstants.getBoardSizeCols()) {
            throw new InvalidPositionException(ExceptionMessages.INVALID_COORDINATES_EXCEPTION_MESSAGE);
        }
        this.y = y;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return String.format(GameMessages.POSITION_MESSAGE, this.x, this.y);
    }
}
