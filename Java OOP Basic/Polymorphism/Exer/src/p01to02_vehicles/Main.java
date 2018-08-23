package p01to02_vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Vehicle> vehicles = new LinkedHashMap<>();
        String[] tokens;
        double[] params;
        for (int i = 0; i < 3; i++) {
            tokens = reader.readLine().split("\\s+");
            params= Arrays.stream(tokens)
                    .skip(1)
                    .mapToDouble(Double::parseDouble)
                    .toArray();
            switch (tokens[0]){
                case "p01to02_vehicles.Car":
                    Car car  =new Car(params[0], params[1], params[2]);
                    vehicles.put("p01to02_vehicles.Car", car);
                    break;
                case "p01to02_vehicles.Bus":
                    Bus bus  =new Bus(params[0], params[1], params[2]);
                    vehicles.put("p01to02_vehicles.Bus", bus);
                    break;
                case "p01to02_vehicles.Truck":
                    Truck truck  =new Truck(params[0], params[1], params[2]);
                    vehicles.put("p01to02_vehicles.Truck", truck);
                    break;
            }
        }
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            tokens = reader.readLine().split("\\s+");
            String command = tokens[0];
            String vehicleType = tokens[1];
            double param = Double.parseDouble(tokens[2]);
            try {
                Vehicle vehicle = vehicles.get(vehicleType);
                switch (command){
                    case "Drive":
                        vehicle.drive(param);
                        break;
                    case "Refuel":
                        vehicle.refuel(param);
                        break;
                    case "DriveEmpty":
                        ((Bus)vehicle).driveEmpty(param);
                        break;
                }
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

        }
        for (Vehicle vehicle:vehicles.values()) {
            vehicle.printFuelQuantity();
        }

    }
}
