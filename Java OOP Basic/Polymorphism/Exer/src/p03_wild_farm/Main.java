package p03_wild_farm;

import p03_wild_farm.animal.*;
import p03_wild_farm.food.Food;
import p03_wild_farm.food.Meat;
import p03_wild_farm.food.Vegetable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Animal> animals = new ArrayList<>();
        String line;
        while (true) {
            line = reader.readLine();
            if ("End".equals(line)) {
                break;
            }
            String[] tokens = line.split("\\s+");

            Animal animal = null;
            try {
                String animalType = tokens[0];
                String animalName = tokens[1];
                double animalWeight = Double.parseDouble(tokens[2]);
                String animalLivingRegion = tokens[3];
                switch (animalType) {
                    case "Tiger":
                        animal = new Tiger(animalType, animalName, animalWeight, animalLivingRegion);
                        break;
                    case "Cat":
                        String catBreed = tokens[4];
                        animal = new Cat(animalType, animalName, animalWeight, animalLivingRegion, catBreed);
                        break;
                    case "Zebra":
                        animal = new Zebra(animalType, animalName, animalWeight, animalLivingRegion);
                        break;
                    case "Mouse":
                        animal = new Mouse(animalType, animalName, animalWeight, animalLivingRegion);
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            if (animal != null) {
                animals.add(animal);
            }

            tokens = reader.readLine().split("\\s+");
            System.out.println(animal.makeSound());
            String foodType = tokens[0];
            int foodQuantity = Integer.parseInt(tokens[1]);
            Food food = null;
            try {
                switch (foodType) {
                    case "Meat":
                        food = new Meat(foodQuantity);
                        break;
                    case "Vegetable":
                        food = new Vegetable(foodQuantity);
                        break;
                }
                if (food != null && !animals.isEmpty()) {
                    animal.eat(food);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        for (Animal animal:animals) {
            System.out.println(animal.toString());

        }
    }

}

