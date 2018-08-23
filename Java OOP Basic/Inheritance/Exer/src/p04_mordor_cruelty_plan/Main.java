package p04_mordor_cruelty_plan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] food = reader.readLine().split("\\s+");
        Gandalf gandalf = new Gandalf();
        gandalf.eatAll(food);
        System.out.println(gandalf.getHappiness());
        System.out.println(gandalf.getMood());
    }
}
