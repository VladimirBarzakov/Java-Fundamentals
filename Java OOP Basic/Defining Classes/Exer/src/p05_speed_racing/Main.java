package p05_speed_racing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Car> cars = new LinkedHashMap<>();
        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String model = tokens[0];
            double fuelAmount = Double.parseDouble(tokens[1]);
            double fuelCost = Double.parseDouble(tokens[2]);
            try {
                Car car = new Car(model,fuelAmount,fuelCost);
                cars.put(model,car);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        String line;
        while (true){
            line= reader.readLine();
            if ("End".equals(line)){
                break;
            }
            String[] tokens = line.split("\\s+");
            String model = tokens[1];
            long distance = Long.parseLong(tokens[2]);
            Car car = cars.get(model);
            if (car.canTravelDistance(distance)){
                car.travel(distance);
            } else{
                System.out.println("Insufficient fuel for the drive");
            }
        }
        cars.values().forEach(System.out::println);
    }
}
