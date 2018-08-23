import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class BasicQueueOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int s = Integer.parseInt(tokens[1]);
        int x = Integer.parseInt(tokens[2]);

        ArrayDeque<Long> deque = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split(" ")).mapToLong(Long::parseLong).forEach(deque::add);
        for (int i = 0; i < s; i++) {
            deque.remove();
        }
        for (Long element:deque) {
            if (element==x){
                System.out.println("true");
                return;
            }
        }
        if (deque.stream().sorted().findFirst().isPresent()){
            System.out.println(deque.stream().sorted().findFirst().get());
        } else{
            System.out.println(0);
        }
    }
}
