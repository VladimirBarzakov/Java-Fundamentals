package p05_pizza_calories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza() {
    }

    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setToppings(numberOfToppings);
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    private void setName(String name){
        if (name==null||name.isEmpty()||name.length()>15){
            throw new IllegalArgumentException("p05.Pizza name should be between 1 and 15 symbols.");
        }
        this.name=name;
    }

    private void setToppings(int numOfToppings){
        if (numOfToppings<0 || numOfToppings>10){
            throw  new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppings = new ArrayList<>(numOfToppings);
    }

    public double getPizzaCalories(){
        double pizzaCalories = this.dough.getDoughCalories();
        for (Topping topping:this.toppings) {
            pizzaCalories+=topping.getToppingCalories();
        }
        return pizzaCalories;
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f",this.name, this.getPizzaCalories());
    }
}
