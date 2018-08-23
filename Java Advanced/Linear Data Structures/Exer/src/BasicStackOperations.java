import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class BasicStackOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int s = Integer.parseInt(tokens[1]);
        int x = Integer.parseInt(tokens[2]);

        ArrayDeque<Long> stack = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split(" ")).mapToLong(Long::parseLong).forEach(stack::push);
        for (int i = 0; i < s; i++) {
            stack.pop();
        }
        for (Long element:stack) {
            if (element==x){
                System.out.println("true");
                return;
            }
        }
        if (stack.stream().sorted().findFirst().isPresent()){
            System.out.println(stack.stream().sorted().findFirst().get());
        } else{
            System.out.println(0);
        }

    }
}
