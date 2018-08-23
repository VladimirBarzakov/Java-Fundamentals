package p05_comparing_objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Person> people = new ArrayList<>();
        String[] tokens;
        while (true){
            tokens=reader.readLine().split("\\s+");
            if ("END".equals(tokens[0])){
                break;
            }
            people.add(new Person(tokens[0],Integer.parseInt(tokens[1]), tokens[2]));
        }
        int n = Integer.parseInt(reader.readLine())-1;
        int counter = 1;
        for (int i = 0; i < people.size(); i++) {
            if (n!=i){
                if (people.get(i).compareTo(people.get(n))==0){
                    counter++;
                }
            }
        }
        if (counter==1){
            System.out.println("No matches");
            return;
        }
        System.out.printf("%d %d %d", counter, people.size()-counter,people.size());
    }
}
