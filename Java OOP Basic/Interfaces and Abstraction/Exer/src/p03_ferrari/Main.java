package p03_ferrari;

import java.lang.instrument.IllegalClassFormatException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalClassFormatException {
        String ferrariName = Ferrari.class.getSimpleName();
        String carInterface = Car.class.getSimpleName();
        boolean isCreated = Car.class.isInterface();
        if (!isCreated) {
            throw new IllegalClassFormatException("No interface created!");
        }

        Scanner scanner = new Scanner(System.in);
        String driver = scanner.nextLine();
        Car car = new Ferrari(driver);
        System.out.println(car.toString());

    }
}
