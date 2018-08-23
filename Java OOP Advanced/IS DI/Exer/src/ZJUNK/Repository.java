package ZJUNK;

import contracts.Modelable;
import exeptions.DuplicateModelException;
import exeptions.NonExistentModelException;
import utility.Constants;

import java.util.LinkedHashMap;
import java.util.Map;

public class Repository<T extends Modelable> implements contracts.Repository {
    private Map<String, T> itemsByModel;

    public Repository()
    {
        this.itemsByModel=new LinkedHashMap<>();
    }

    @Override
    public void add(Modelable item) throws DuplicateModelException {
        if (this.itemsByModel.containsKey(item.getModel()))
        {
            throw new DuplicateModelException(Constants.DUPLICATE_MODEL_MESSAGE);
        }

    }

    @Override
    public T getItem(String model) throws NonExistentModelException {
        if (!this.itemsByModel.containsKey(model))
        {
            throw new NonExistentModelException(Constants.NON_EXISTENT_MODEL_MESSAGE);
        }

        return this.itemsByModel.get(model);
    }

}
