package p03_dependency_inversion_skeleton;

import p03_dependency_inversion_skeleton.contracts.Strategy;
import p03_dependency_inversion_skeleton.strategies.AdditionStrategy;
import p03_dependency_inversion_skeleton.strategies.DivideStrategy;
import p03_dependency_inversion_skeleton.strategies.MultiplyStrategy;
import p03_dependency_inversion_skeleton.strategies.SubtractionStrategy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrimitiveCalculator calculator = new PrimitiveCalculator(new AdditionStrategy());
        String line;
        while (true){
            line=scanner.nextLine();

            if (line.equals("End")){
                break;
            }
            String[] tokens =line.split("\\s+");
            if (line.contains("mode")){
                char mode = tokens[1].charAt(0);
                Strategy strategy = null;
                switch (mode){
                    case '+':strategy = new AdditionStrategy();
                    break;
                    case '-':strategy = new SubtractionStrategy();
                    break;
                    case '*':strategy = new MultiplyStrategy();
                    break;
                    case '/':strategy = new DivideStrategy();
                }
                calculator.changeStrategy(strategy);
            } else{
                int num1 = Integer.parseInt(tokens[0]);
                int num2 = Integer.parseInt(tokens[1]);
                System.out.println(calculator.performCalculation(num1, num2));
            }
        }
    }
}
