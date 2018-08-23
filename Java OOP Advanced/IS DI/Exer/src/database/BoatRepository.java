package database;

import contracts.Boat;
import contracts.Repository;
import exeptions.DuplicateModelException;
import exeptions.NonExistentModelException;

import java.util.LinkedHashMap;
import java.util.Map;

import static utility.Constants.DUPLICATE_MODEL_MESSAGE;
import static utility.Constants.NON_EXISTENT_MODEL_MESSAGE;

public class BoatRepository implements Repository<Boat> {
    private Map<String, Boat> boatMap;

    public BoatRepository() {
        this.boatMap = new LinkedHashMap<>();
    }

    @Override
    public void add(Boat item) throws DuplicateModelException {
        if (this.boatMap.containsKey(item.getModel())){
            throw new DuplicateModelException(DUPLICATE_MODEL_MESSAGE);
        }
        this.boatMap.put(item.getModel(),item);
    }

    @Override
    public Boat getItem(String model) throws NonExistentModelException {
        if (!this.boatMap.containsKey(model)){
            throw new NonExistentModelException(NON_EXISTENT_MODEL_MESSAGE);
        }
        return this.boatMap.get(model);
    }
}
