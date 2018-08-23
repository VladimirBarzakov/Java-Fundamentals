package p07_car_salesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Engine> engines = new HashMap<>();
        List<Car> cars = new ArrayList<>();
        int n =Integer.parseInt(reader.readLine());
        readEngines(reader, engines, n);
        n = Integer.parseInt(reader.readLine());
        readCars(reader, engines, cars, n);
        cars.forEach(System.out::println);
    }

    private static void readCars(BufferedReader reader, Map<String, Engine> engines, List<Car> cars, int n) throws IOException {
        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String carModel = tokens[0];
            Engine engine = engines.get(tokens[1]);
            Long weight=null;
            String color = null;
            if (tokens.length==4){
                weight=Long.parseLong(tokens[2]);
                color = tokens[3];
            } else if(tokens.length==3){
                try {
                    weight=Long.parseLong(tokens[2]);
                } catch (NumberFormatException e){
                    color = tokens[2];
                }
            }
            Car car = new Car(carModel,engine,weight,color);
            cars.add(car);
        }
    }

    private static void readEngines(BufferedReader reader, Map<String, Engine> engines, int n) throws IOException {
        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String engineModel = tokens[0];
            long enginePower = Long.parseLong(tokens[1]);
            Long engineDisplacement=null;
            String engineEfficiency=null;
            Engine engine = null;
            if (tokens.length==4){
                engineDisplacement=Long.parseLong(tokens[2]);
                engineEfficiency=tokens[3];
            } else if(tokens.length==3){
                try {
                    engineDisplacement=Long.parseLong(tokens[2]);
                } catch (NumberFormatException e){
                    engineEfficiency=tokens[2];
                }
            }
            engine = new Engine(engineModel,enginePower,engineDisplacement,engineEfficiency);
            engines.put(engineModel,engine);
        }
    }
}
