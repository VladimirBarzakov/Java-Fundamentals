package models.boats;

import contracts.Boat;

import static utility.Constants.MIN_BOAT_MODEL_LENGTH;
import static utility.Constants.MODEL_S_NAME_MUST_BE_AT_LEAST_S_SYMBOLS_LONG;
import static utility.Constants.S_MUST_BE_A_POSITIVE_INTEGER;

public abstract class BaseBoat implements Boat {
    private String model;
    private int weight;

    protected BaseBoat(String model, int weight) {
        this.setModel(model);
        this.setWeight(weight);
    }

    private void setModel(String model) {
        if (model.length()<MIN_BOAT_MODEL_LENGTH){
            throw new IllegalArgumentException(String.format(
                    MODEL_S_NAME_MUST_BE_AT_LEAST_S_SYMBOLS_LONG,
                    MIN_BOAT_MODEL_LENGTH));
        }
        this.model = model;
    }

    private void setWeight(int weight) {
        if (weight<=0){
            throw new IllegalArgumentException(String.format(
                    S_MUST_BE_A_POSITIVE_INTEGER,"Weight"));
        }
        this.weight = weight;
    }

    protected int getWeight() {
        return this.weight;
    }

    @Override
    public String getModel() {
        return this.model;
    }

}
