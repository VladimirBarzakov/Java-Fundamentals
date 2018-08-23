package models.engines;

import contracts.BoatEngine;

import static utility.Constants.MIN_BOAT_ENGINE_MODEL_LENGTH;
import static utility.Constants.MODEL_S_NAME_MUST_BE_AT_LEAST_S_SYMBOLS_LONG;
import static utility.Constants.S_MUST_BE_A_POSITIVE_INTEGER;

public abstract class BaseBoatEngine implements BoatEngine {
    private String model;
    private int horsepower;
    private int displacement;
    private long output;

    protected BaseBoatEngine(String model, int horsepower, int displacement, long multiplier ) {
        this.setModel(model);
        this.setHorsepower(horsepower);
        this.setDisplacement(displacement);
        this.setOutput(horsepower,displacement,multiplier);
    }

    private void setHorsepower(int horsepower) {
        if (horsepower<=0){
            throw new IllegalArgumentException(String.format(
                    S_MUST_BE_A_POSITIVE_INTEGER,"Horsepower"));
        }
        this.horsepower = horsepower;
    }

    private void setDisplacement(int displacement) {
        if (displacement<=0){
            throw new IllegalArgumentException(String.format(
                    S_MUST_BE_A_POSITIVE_INTEGER,"Displacement"));
        }
        this.displacement = displacement;
    }

    private void setOutput(int horsepower, int displacement, long multiplier) {
        this.output = (horsepower*multiplier)+displacement;
    }

    private void setModel(String model) {
        if (model.length()<MIN_BOAT_ENGINE_MODEL_LENGTH){
            throw new IllegalArgumentException(String.format(
                    MODEL_S_NAME_MUST_BE_AT_LEAST_S_SYMBOLS_LONG,
                    MIN_BOAT_ENGINE_MODEL_LENGTH));
        }
        this.model = model;
    }

    @Override
    public long getOutput() {
        return this.output;
    }

    @Override
    public String getModel() {
        return this.model;
    }
}
