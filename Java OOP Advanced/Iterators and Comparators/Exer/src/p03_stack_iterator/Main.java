package p03_stack_iterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        String line;
        while (true){
            line=reader.readLine();
            if ("END".equals(line)){
                for (Integer num:stack) {
                    System.out.println(num);
                }
                for (Integer num:stack) {
                    System.out.println(num);
                }
                break;
            }
            String[] tokens = line.split("\\s+");
            String command = tokens[0];
            switch (command){
                case "Push":
                    Integer[] numbers = Arrays.stream(line.substring(5).split(", "))
                            .map(x->Integer.parseInt(x.trim())).toArray(Integer[]::new);
                    stack.push(numbers);
                    break;
                case "Pop":
                    stack.pop();
                    break;
            }
        }
    }
}
