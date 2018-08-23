package p03_animal_falm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        int age = Integer.parseInt(reader.readLine());
        DecimalFormat format = new DecimalFormat("0.###########################");
        Chiken chiken =null;
        try {
            chiken=new Chiken(name,age);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        if (chiken!=null){
            System.out.printf("Chicken %s (age %d) can produce %s eggs per day.",chiken.getName(), chiken.getAge(), format.format(chiken.productPerDay()));
        }
    }
}
