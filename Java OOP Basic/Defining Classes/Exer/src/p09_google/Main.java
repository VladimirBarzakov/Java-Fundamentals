package p09_google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Person> persons = new HashMap<>();
        String line;
        while (true){
            line=reader.readLine();
            if ("End".equals(line)){
                break;
            }
            String[] tokens = line.split("\\s+");
            String name = tokens[0];
            if (!persons.containsKey(name)){
                persons.put(name, new Person(name));
            }
            String objType = tokens[1];
            switch (objType){
                case "company":
                    Company company = new Company(tokens[2],tokens[3], Double.parseDouble(tokens[4]));
                    persons.get(name).setCompany(company);
                    break;
                case "pokemon":
                    Pokemon pokemon = new Pokemon(tokens[2], tokens[3]);
                    persons.get(name).addPokemon(pokemon);
                    break;
                case "parents":
                    Parent parent = new Parent(tokens[2],tokens[3]);
                    persons.get(name).addParent(parent);
                    break;
                case "children":
                    Child child = new Child(tokens[2],tokens[3]);
                    persons.get(name).addChild(child);
                    break;
                case "car":
                    Car car = new Car(tokens[2],Long.parseLong(tokens[3]));
                    persons.get(name).setCar(car);
                    break;
            }
        }
        String name = reader.readLine();
        System.out.println(persons.get(name));
    }
}
