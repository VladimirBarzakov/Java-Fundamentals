package app.interfaces.gameModels;

import app.exceptions.IllegalPositionException;
import app.exceptions.InvalidPositionException;


import java.util.List;

public interface Battleground {

    List<Unit> getUnitsInRange(Position position, int range);

    void add(Unit unit) throws IllegalPositionException;

    void remove(Unit unit) throws IllegalPositionException;

    void move(Unit unit, Position position) throws IllegalPositionException;
}
