import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateForNames {

    private static BufferedReader br;

    static {
        br=new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        ArrayList<String> names = Arrays.stream(br.readLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayList::new));

        Predicate<String> isInBorder = x->x.length()<=n;
        for (String name:names) {
            if (isInBorder.test(name)){
                System.out.println(name);
            }
        }
    }
}
