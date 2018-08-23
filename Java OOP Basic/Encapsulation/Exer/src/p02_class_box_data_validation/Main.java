package p02_class_box_data_validation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Box box =null;
        double[] params = new double[3];
        for (int i = 0; i < 3; i++) {
            params[i]=Double.parseDouble(reader.readLine());
        }
        try {
            box = new Box(params[0], params[1], params[2]);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        if (box!=null){
            System.out.printf("Surface Area - %.2f%n",box.getSurfaceArea());
            System.out.printf("Lateral Surface Area - %.2f%n", box.getLateralSurfaceArea());
            System.out.printf("Volume - %.2f%n", box.getVolume());
        }


    }
}
