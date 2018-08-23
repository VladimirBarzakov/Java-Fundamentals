package app;

import app.controller.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Controller controller = new Controller();
        String line;

        while (true){
            line=reader.readLine();
            String[] commandArgs = line.split("\\s+");
            String result = controller.executeCommand(commandArgs);
            if (result!=null){
                System.out.println(result);
            }
            if ("Quit".equals(line)){
                break;
            }
        }
    }
}
