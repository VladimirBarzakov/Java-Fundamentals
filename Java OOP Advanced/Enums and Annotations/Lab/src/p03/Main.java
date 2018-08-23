package p03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        String line;
        while (true){
            line=reader.readLine();
            if ("END".equals(line)){
                break;
            }
            String[] tokens = line.split("\\s+");
            if (tokens.length==1){
                coffeeMachine.insertCoin(tokens[0]);
            } else if(tokens.length==2){
                coffeeMachine.buyCoffee(tokens[0], tokens[1]);
            }
        }
    }
}
