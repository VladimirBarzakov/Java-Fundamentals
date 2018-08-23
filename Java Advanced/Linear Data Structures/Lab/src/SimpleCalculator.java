import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;

public class SimpleCalculator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();
        Collections.addAll(stack, tokens);
        long sum=0;
        while (!stack.isEmpty()){
            String element = stack.pop();
            if ("+".equals(element)){
                sum+=Long.parseLong(stack.pop());
            } else if ("-".equals(element)){
                sum-=Long.parseLong(stack.pop());
            } else{
                sum+=Long.parseLong(element);
            }
        }
        System.out.println(sum);
    }
}
