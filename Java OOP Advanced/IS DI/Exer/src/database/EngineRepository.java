package database;

import contracts.BoatEngine;
import contracts.Repository;
import exeptions.DuplicateModelException;
import exeptions.NonExistentModelException;

import java.util.LinkedHashMap;
import java.util.Map;

import static utility.Constants.DUPLICATE_MODEL_MESSAGE;
import static utility.Constants.NON_EXISTENT_MODEL_MESSAGE;

public class EngineRepository implements Repository<BoatEngine> {
    private Map<String, BoatEngine> engineMap;

    public EngineRepository() {
        this.engineMap=new LinkedHashMap<>();
    }

    @Override
    public void add(BoatEngine item) throws DuplicateModelException {
        if (this.engineMap.containsKey(item.getModel())){
            throw new DuplicateModelException(DUPLICATE_MODEL_MESSAGE);
        }
        this.engineMap.put(item.getModel(),item);
    }

    @Override
    public BoatEngine getItem(String model) throws NonExistentModelException {
        if (!this.engineMap.containsKey(model)){
            throw new NonExistentModelException(NON_EXISTENT_MODEL_MESSAGE);
        }
        return this.engineMap.get(model);
    }
}
