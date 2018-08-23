package p03_dependency_inversion_skeleton;

import p03_dependency_inversion_skeleton.contracts.Strategy;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2){
        return this.strategy.calculate(num1, num2);
    }
}
