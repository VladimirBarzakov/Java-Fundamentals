package p04_telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] callNumbers = reader.readLine().split("\\s+");
        String[] callURLs = reader.readLine().split("\\s+");
        Phone phone = new Phone();
        for (int i = 0; i < callNumbers.length; i++) {
            System.out.println(phone.call(callNumbers[i]));
        }
        for (int i = 0; i < callURLs.length; i++) {
            System.out.println(phone.visit(callURLs[i]));
        }
    }
}
