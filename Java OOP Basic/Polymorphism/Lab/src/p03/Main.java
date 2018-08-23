package p03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Shape shape = new Rectangle(4d,3d);
        System.out.println(shape.getArea());
    }
}
