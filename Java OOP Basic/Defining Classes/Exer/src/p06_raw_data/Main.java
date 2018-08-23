package p06_raw_data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<Car>> carsByCargoType = new HashMap<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String model = tokens[0];
            long engineSpeed = Long.parseLong(tokens[1]);
            long enginePower = Long.parseLong(tokens[2]);
            long cargoWeight = Long.parseLong(tokens[3]);
            String cargoType = tokens[4];
            long tire1Age = Long.parseLong(tokens[6]);
            double tire1Pressure = Double.parseDouble(tokens[5]);
            long tire2Age = Long.parseLong(tokens[8]);
            double tire2Pressure = Double.parseDouble(tokens[7]);
            long tire3Age = Long.parseLong(tokens[10]);
            double tire3Pressure = Double.parseDouble(tokens[9]);
            long tire4Age = Long.parseLong(tokens[12]);
            double tire4Pressure = Double.parseDouble(tokens[11]);
            Car car = new Car(model,
                    engineSpeed,enginePower,
                    cargoWeight,cargoType,
                    tire1Age,tire1Pressure,
                    tire2Age,tire2Pressure,
                    tire3Age,tire3Pressure,
                    tire4Age,tire4Pressure);
            if (!carsByCargoType.containsKey(cargoType)){
                carsByCargoType.put(cargoType,new ArrayList<>());
            }
            carsByCargoType.get(cargoType).add(car);
        }
        String command = reader.readLine();
        switch (command){
            case "fragile":
                carsByCargoType.get(command).stream().filter(
                        x-> Arrays.stream(x.getTires()).anyMatch(t->t.getTirePressure()<1))
                        .forEach(x-> System.out.println(x.getModel()));
                break;
            case "flamable":
                carsByCargoType.get(command).stream().filter(x->x.getEngine().getEnginePower()>250)
                        .forEach(x-> System.out.println(x.getModel()));
                break;
        }
    }
}
