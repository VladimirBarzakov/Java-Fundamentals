import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class DecimalToBinaryConverter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long decimal = Long.parseLong(reader.readLine());
        if (decimal==0){
            System.out.println(0);
            return;
        }

        ArrayDeque<Byte> stack = new ArrayDeque<>();
        while (decimal!=0){
            stack.push((byte)(decimal%2));
            decimal/=2;
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }

    }
}
