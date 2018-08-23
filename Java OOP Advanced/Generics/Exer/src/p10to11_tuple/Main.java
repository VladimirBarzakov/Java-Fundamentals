package p10to11_tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split("\\s+");
        Threeuple<String, String, String> nameAndAddressAndTown = new Threeuple<>(tokens[0]+" "+tokens[1],tokens[2], tokens[3]);
        tokens = reader.readLine().split("\\s+");
        Threeuple<String, Integer, Boolean> nameAndAmountOfBeerAndIsDrunk = new Threeuple<>(tokens[0],Integer.parseInt(tokens[1]),tokens[2].equals("drunk"));
        tokens = reader.readLine().split("\\s+");
        Threeuple<String, Double,String> nameAndBalanceAndBank = new Threeuple<>(tokens[0],Double.parseDouble(tokens[1]),tokens[2]);

        System.out.println(nameAndAddressAndTown);
        System.out.println(nameAndAmountOfBeerAndIsDrunk);
        System.out.println(nameAndBalanceAndBank);
    }
}
