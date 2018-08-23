import controller.HealthManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HealthManager healthManager = new HealthManager();
        String line;
        String result=null;
        while (true){
            line=reader.readLine();
            if ("BEER IS COMING".equals(line)){
                break;
            }
            String[] tokens = line.split("\\s+");
            switch (tokens[0]){
                case "createOrganism":
                    result=healthManager.createOrganism(tokens[1]);
                    break;
                case "addCluster":
                    result=healthManager.addCluster(
                            tokens[1],
                            tokens[2],
                            Integer.parseInt(tokens[3]),
                            Integer.parseInt(tokens[4]));
                    break;
                case "addCell":
                    result = healthManager.addCell(
                            tokens[1],
                            tokens[2],
                            tokens[3],
                            tokens[4],
                            Integer.parseInt(tokens[5]),
                            Integer.parseInt(tokens[6]),
                            Integer.parseInt(tokens[7]),
                            Integer.parseInt(tokens[8]));
                    break;
                case "checkCondition":
                    result=healthManager.checkCondition(tokens[1]);
                    break;
                case "activateCluster":
                    result=healthManager.activateCluster(tokens[1]);
                    break;
            }
            if (result!=null){
                System.out.println(result);
            }

        }
    }
}
