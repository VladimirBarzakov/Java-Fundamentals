import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class SumNumbers {

    private static BufferedReader br;

    static {
        br=new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        String[] line = br.readLine().split(", ");

        Function<String, Integer> parser = x->Integer.parseInt(x);
        System.out.println("Count = "+line.length);
        long sum=0;
        for (String element:line ) {
            sum+=parser.apply(element);
        }
        System.out.println("Sum = "+sum);
    }
}
