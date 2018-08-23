import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class ConsumerPrint {

    private static BufferedReader br;

    static {
        br=new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        String[] arr = br.readLine().split("\\s+");
        Consumer<String> print = s-> System.out.println(s);

        for (int i = 0; i < arr.length; i++) {
            print.accept(arr[i]);
        }
    }
}
