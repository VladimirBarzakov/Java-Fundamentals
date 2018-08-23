import controller.CarManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CarManager carManager = new CarManager();
        String line;
        StringBuilder builder = new StringBuilder();

        while (true){
            line=reader.readLine();
            if ("Cops Are Here".equals(line)){
                break;
            }
            String[] tokens = line.split("\\s+");
            String commandType = tokens[0];
            String result=null;
            switch (commandType){
                case "register":
                    carManager.register(
                            Integer.parseInt(tokens[1]),
                            tokens[2],
                            tokens[3],
                            tokens[4],
                            Integer.parseInt(tokens[5]),
                            Integer.parseInt(tokens[6]),
                            Integer.parseInt(tokens[7]),
                            Integer.parseInt(tokens[8]),
                            Integer.parseInt(tokens[9]));
                    break;
                case "check":
                    result = carManager.check(Integer.parseInt(tokens[1]));
                    break;
                case "open":
                    if (tokens[2].equals("Circuit") || tokens[2].equals("TimeLimit")){
                        carManager.open(
                                Integer.parseInt(tokens[1]),
                                tokens[2],
                                Integer.parseInt(tokens[3]),
                                tokens[4],
                                Integer.parseInt(tokens[5]),
                                Integer.parseInt(tokens[6]));
                    } else{
                        carManager.open(
                                Integer.parseInt(tokens[1]),
                                tokens[2],
                                Integer.parseInt(tokens[3]),
                                tokens[4],
                                Integer.parseInt(tokens[5]));
                    }
                    break;
                case "participate":
                    carManager.participate(Integer.parseInt(tokens[1]),
                            Integer.parseInt(tokens[2]));
                    break;
                case "start":
                    result=carManager.start(Integer.parseInt(tokens[1]));
                    break;
                case "park":
                    carManager.park(Integer.parseInt(tokens[1]));
                    break;
                case "unpark":
                    carManager.unpark(Integer.parseInt(tokens[1]));
                    break;
                case "tune":
                    carManager.tune(Integer.parseInt(tokens[1]),tokens[2]);
                    break;
            }
            if (result!=null){
               builder.append(result).append(System.lineSeparator());
            }
        }
        System.out.println(builder.toString());
    }
}
