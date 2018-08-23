package p03_dependency_inversion_skeleton.strategies;

import p03_dependency_inversion_skeleton.contracts.Strategy;

public class MultiplyStrategy implements Strategy {
    @Override
    public int calculate(int num1, int num2) {
        return num1*num2;
    }
}
