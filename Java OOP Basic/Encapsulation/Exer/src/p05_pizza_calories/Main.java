package p05_pizza_calories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split("\\s+");
        Pizza pizza;
        try {
            String pizzaName = tokens[1];
            int toppingsCount = Integer.parseInt(tokens[2]);
            pizza=new Pizza(pizzaName, toppingsCount);
        } catch (IllegalArgumentException | IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
            return;
        }
        Dough dough;
        tokens=reader.readLine().split("\\s+");
        try {
            String doughName = tokens[1];
            String doughType = tokens[2];
            Double doughWeight = Double.parseDouble(tokens[3]);
            dough = new Dough(doughName, doughType, doughWeight);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }
        if (pizza!=null && dough!=null){
            pizza.setDough(dough);
        } else{
            return;
        }
        while (true){
            tokens = reader.readLine().split("\\s+");
            if ("END".equals(tokens[0])){
                break;
            }
            String toppingType = tokens[1];
            Double toppingWeight = Double.parseDouble(tokens[2]);
            Topping topping;
            try {
                topping = new Topping(toppingType, toppingWeight);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                return;
            }
            pizza.addTopping(topping);
        }
        System.out.println(pizza.toString());
    }
}
