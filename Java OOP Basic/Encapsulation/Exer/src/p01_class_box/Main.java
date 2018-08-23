package p01_class_box;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double[] params = new double[3];
        for (int i = 0; i < 3; i++) {
            params[i]=Double.parseDouble(reader.readLine());
        }
        Box box = new Box(params[0], params[1], params[2]);
        System.out.printf("Surface Area - %.2f%n",box.getSurfaceArea());
        System.out.printf("Lateral Surface Area - %.2f%n", box.getLateralSurfaceArea());
        System.out.printf("Volume - %.2f%n", box.getVolume());
    }
}
