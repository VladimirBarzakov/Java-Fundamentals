package p04_shopping_spree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Person> buyers = new LinkedHashMap<>();
        Map<String, Product> products = new HashMap<>();
        String[] tokens = reader.readLine().split(";");
        for (int i = 0; i < tokens.length; i++) {
            String name = tokens[i].split("=")[0];
            int money = Integer.parseInt(tokens[i].split("=")[1]);
            Person person = null;
            try {
                person = new Person(name, money);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                return;
            }
            if (person!=null){
                buyers.put(name, person);
            }
        }
        tokens = reader.readLine().split(";");
        for (int i = 0; i < tokens.length; i++) {
            String name = tokens[i].split("=")[0];
            int cost = Integer.parseInt(tokens[i].split("=")[1]);
            Product product = null;
            try {
                product = new Product(name, cost);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                return;
            }
            if (product!=null){
                products.put(name, product);
            }
        }
        String line;
        while (true){
            line=reader.readLine();
            if ("END".equals(line)){
                break;
            }
            tokens=line.split("\\s+");
            Person person = buyers.get(tokens[0]);
            Product product = products.get(tokens[1]);
            if (person.buyProduct(product)){
                System.out.printf("%s bought %s%n",person.getName(),product.getName());
            } else{
                System.out.printf("%s can't afford %s%n",person.getName(),product.getName());
            }
        }
        buyers.values().stream().forEach(person->{
            if (person.getProductBag().isEmpty()){
                System.out.printf("%s - Nothing bought%n",person.getName());
            } else{
                System.out.printf("%s - ",person.getName());
                System.out.println(Arrays.toString(person.getProductBag().stream().map(Product::getName).toArray()).replaceAll("[\\[\\]]",""));
            }
        });


    }
}
