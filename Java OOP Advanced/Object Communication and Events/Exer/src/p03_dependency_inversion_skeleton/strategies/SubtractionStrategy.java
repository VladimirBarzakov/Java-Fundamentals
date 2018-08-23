package p03_dependency_inversion_skeleton.strategies;

import p03_dependency_inversion_skeleton.contracts.Strategy;

public class SubtractionStrategy implements Strategy {

    @Override
    public int calculate(int firstOperand, int secondOperand){
        return firstOperand - secondOperand;
    }
}
