package p06_animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (true){
            line = reader.readLine();
            if ("Beast!".equals(line)){
                break;
            }
            try {
                String type = line;
                String[] tokens =reader.readLine().split("\\s+");
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                Animal animal = null;
                switch (type){
                    case "p06_animals.Dog":
                        animal = new Dog(type,name,age,tokens[2]);
                        break;
                    case "p06_animals.Cat":
                        animal = new Cat(type,name, age, tokens[2]);
                        break;
                    case "p06_animals.Frog":
                        animal= new Frog(type, name, age, tokens[2]);
                        break;
                    case "p06_animals.Kitten":
                        animal = new Kitten(type,name,age, tokens[2]);
                        break;
                    case "p06_animals.Tomcat":
                        animal = new Tomcat(type, name, age, tokens[2]);
                        break;
                    case "p06_animals.Animal":
                        animal = new Animal(type, name, age, tokens[2]);
                        break;
                        default:
                            throw new  IllegalArgumentException();


                }
                System.out.println(animal);
                System.out.println(animal.produceSound());
            } catch (Exception e){
                System.out.println("Invalid input!");
        }
        }
    }
}
