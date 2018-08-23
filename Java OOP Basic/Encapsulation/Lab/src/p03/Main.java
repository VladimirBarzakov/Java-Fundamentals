package p03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        //TODO: Add reading logic
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            try {
                people.add(new Person(tokens[0],
                        tokens[1],
                        Integer.parseInt(tokens[2]),
                        Double.parseDouble(tokens[3])));
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

        }

        Double bonus = Double.parseDouble(reader.readLine());
        for (Person person : people) {
            person.increaseSalary(bonus);
            System.out.println(person.toString());
        }
    }
}
