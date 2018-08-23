package app.battleGround;

import app.constants.ExceptionMessages;
import app.constants.GameConstants;
import app.exceptions.IllegalPositionException;
import app.interfaces.gameModels.Battleground;
import app.interfaces.gameModels.Position;
import app.interfaces.gameModels.Unit;

import java.util.ArrayList;
import java.util.List;

public class BattleGroundImpl implements Battleground {

    private Unit[][] battleGround;

    public BattleGroundImpl() {
        this.battleGround = new Unit[GameConstants.getBoardSizeRows()][GameConstants.getBoardSizeCols()];
    }

    private Unit mapPositionToCoordinatesUnit(Position position) {
        return battleGround[position.getX()][position.getY()];
    }

    @Override
    public List<Unit> getUnitsInRange(Position position, int range) {
        List<Unit> result = new ArrayList<>();
        for (int r = position.getX() - range; r <= position.getX() + range; r++) {
            for (int c = position.getY() - range; c <= position.getY() + range; c++) {
                if (r >= 0 && r < this.battleGround.length && c >= 0 && c < this.battleGround[r].length) {
                    if (r == position.getX() && c == position.getY()) {
                        continue;
                    }
                    if (this.battleGround[r][c] == null) {
                        continue;
                    }
                    int distanceAxisX = Math.abs(position.getX() - r);
                    int distanceAxisY = Math.abs(position.getY() - c);
                    if ((distanceAxisX * distanceAxisX) + (distanceAxisY * distanceAxisY) > (range * range)) {
                        continue;
                    }
                    result.add(this.battleGround[r][c]);
                }
            }
        }
        return result;
    }

    @Override
    public void add(Unit unit) throws IllegalPositionException {
        Unit boardUnit = this.mapPositionToCoordinatesUnit(unit.getPosition());
        if (boardUnit != null) {
            throw new IllegalPositionException(ExceptionMessages.POSITION_NOT_EMPTY_EXCEPTION_MESSAGE);
        }
        this.battleGround[unit.getPosition().getX()][unit.getPosition().getY()] = unit;
    }

    @Override
    public void remove(Unit unit) throws IllegalPositionException {
        Unit boardUnit = this.mapPositionToCoordinatesUnit(unit.getPosition());
        if (boardUnit == null) {
            throw new IllegalPositionException(ExceptionMessages.NOT_EXISTING_UNIT_EXCEPTION_MESSAGE);
        }
        this.battleGround[unit.getPosition().getX()][unit.getPosition().getY()] = null;
    }

    @Override
    public void move(Unit unit, Position position) throws IllegalPositionException {
        Unit destinationBoardUnit = this.mapPositionToCoordinatesUnit(position);
        if (destinationBoardUnit != null) {
            throw new IllegalPositionException(ExceptionMessages.POSITION_NOT_EMPTY_EXCEPTION_MESSAGE);
        }

        Unit sourceBoardUnit = this.mapPositionToCoordinatesUnit(unit.getPosition());
        if (sourceBoardUnit == null) {
            throw new IllegalPositionException(ExceptionMessages.NO_UNIT_TO_REMOVE_EXCEPTION_MESSAGE);
        }
        this.battleGround[position.getX()][position.getY()] = unit;
        this.battleGround[unit.getPosition().getX()][unit.getPosition().getY()] = null;
        unit.setPosition(position);

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("  ");
        for (int i = 0; i < this.battleGround[0].length; i++) {
            builder.append(i).append(" ");
        }
        builder.append(System.lineSeparator());
        for (int r = 0; r < this.battleGround.length; r++) {
            builder.append(r).append(" ");
            for (int c = 0; c < this.battleGround[r].length; c++) {
                if (this.battleGround[r][c] == null) {
                    builder.append("-");
                } else {
                    switch (this.battleGround[r][c].getClass().getSimpleName()) {
                        case "Marine":
                            builder.append("M");
                            break;
                        case "Carrier":
                            builder.append("C");
                            break;
                    }
                }
                builder.append(" ");
            }
            builder.append(System.lineSeparator());
        }
        return builder.delete(builder.length() - System.lineSeparator().length() - 1, builder.length() - 1).toString();
    }
}
