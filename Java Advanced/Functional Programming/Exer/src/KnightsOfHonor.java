import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;
import java.util.function.Function;

public class KnightsOfHonor {

    private static BufferedReader br;
    static {
        br=new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        String[] arr = br.readLine().split("\\s+");
        Consumer<String> print = s-> System.out.println(s);
        Function<String, String> addKnightTitle = s-> String.format("Sir %s",s);

        for (int i = 0; i < arr.length; i++) {
            arr[i]=addKnightTitle.apply(arr[i]);
            print.accept(arr[i]);
        }
    }
}
