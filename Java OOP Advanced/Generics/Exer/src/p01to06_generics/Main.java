package p01to06_generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Box<Double>> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            Box<Double> box = new Box<>(Double.parseDouble(sc.nextLine()));
            list.add(box);
        }
        System.out.println(Box.countGreater(list, Double.parseDouble(sc.nextLine())));
    }
}
