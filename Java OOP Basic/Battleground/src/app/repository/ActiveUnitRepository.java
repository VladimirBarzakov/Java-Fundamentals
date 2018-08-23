package app.repository;

import app.constants.ExceptionMessages;
import app.exceptions.InvalidUnitException;
import app.interfaces.gameModels.ActiveRepository;
import app.interfaces.gameModels.Unit;

import java.util.*;

public class ActiveUnitRepository implements ActiveRepository<Unit> {
    private Map<String, Unit> activeUnits;

    public ActiveUnitRepository() {
        activeUnits = new HashMap<>();
    }

    @Override
    public void save(Unit element) throws InvalidUnitException {
        if (activeUnits.containsKey(element.getName())) {
            throw new InvalidUnitException(ExceptionMessages.DUPLICATE_UNIT_EXCEPTION_MESSAGE);
        }
        this.activeUnits.put(element.getName(), element);
    }

    @Override
    public void remove(Unit element) throws InvalidUnitException {
        if (!activeUnits.containsKey(element.getName())) {
            throw new InvalidUnitException(ExceptionMessages.NO_UNIT_TO_REMOVE_EXCEPTION_MESSAGE);
        }
        this.activeUnits.remove(element.getName());
    }

    @Override
    public List<Unit> findAll() {
        return Collections.unmodifiableList(new ArrayList<>(this.activeUnits.values()));
    }

    @Override
    public Unit getEntity(String key) throws InvalidUnitException {
        if (!this.activeUnits.containsKey(key)) {
            throw new InvalidUnitException(ExceptionMessages.MISSING_UNIT_NAME_EXCEPTION_MESSAGE);
        }
        return activeUnits.get(key);
    }
}
