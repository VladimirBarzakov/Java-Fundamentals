package p05_pizza_calories;

import java.util.HashMap;
import java.util.Map;

public class Dough {

    private static final Map<String, Double> DOUGH_TYPES = new HashMap<String, Double>(){{
            put("White", 1.5);
            put("Wholegrain",1d);
            put("Crispy", 0.9);
            put("Chewy", 1.1);
            put("Homemade", 1.0);
    }};

    private String doughType;
    private String doughTechnique;
    private Double weight;


    public Dough(String doughType, String doughTechnique, Double weight) {
        this.setDoughType(doughType);
        this.setDoughTechnique(doughTechnique);
        this.setWeight(weight);
    }

    private void setDoughType(String type){
        if (!DOUGH_TYPES.containsKey(type)){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.doughType = type;
    }

    private void setDoughTechnique(String technique){
        if (!DOUGH_TYPES.containsKey(technique)){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.doughTechnique = technique;
    }

    private void setWeight(Double weight){
        if (weight<1 || weight>200){
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight=weight;
    }

    public double getDoughCalories(){
        return 2*this.weight*DOUGH_TYPES.get(this.doughType)*DOUGH_TYPES.get(this.doughTechnique);
    }

}
