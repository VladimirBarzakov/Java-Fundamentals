package p05_pizza_calories;

import java.util.HashMap;
import java.util.Map;

public class Topping {

    private static final Map<String, Double> TOPPING_TYPES  = new HashMap<String, Double>(){{
        put("Meat", 1.2);
        put("Veggies",0.8);
        put("Cheese",1.1);
        put("Sauce",0.9);

    }};

    private String type;
    private Double weight;

    public Topping() {
    }

    public Topping(String type, Double weight) {
        this.setType(type);
        this.setWeight(weight);
    }

    private void setType(String type){
        if (!TOPPING_TYPES.containsKey(type)){
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.",type));
        }
        this.type=type;
    }

    private void setWeight(Double weight){
        if (weight<1 || weight>50){
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].",this.type));
        }
        this.weight=weight;
    }

    public double getToppingCalories(){
        return this.weight*2*TOPPING_TYPES.get(this.type);
    }


}
