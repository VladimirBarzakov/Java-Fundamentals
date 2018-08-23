import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class ParkingLot {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> parkingLot = new HashSet<>();
        String line;

        while (!"END".equals(line=reader.readLine())){
            String[] input = line.split(", ");
            switch (input[0]){
                case "IN":
                    parkingLot.add(input[1]);
                    break;
                case "OUT":
                    parkingLot.remove(input[1]);
                    break;
            }
        }
        if (parkingLot.isEmpty()){
            System.out.println("Parking Lot is Empty");
        } else{
            for (String carNumber:parkingLot) {
                System.out.println(carNumber);
            }
        }
    }
}
