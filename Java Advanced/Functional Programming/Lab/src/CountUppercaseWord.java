import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWord {

    private static BufferedReader br;
    static {
        br=new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        ArrayList<String> input = Arrays.stream(br.readLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayList::new));
        Predicate<String> isStartWithUpperCase =
                s->s.charAt(0) == s.toUpperCase().charAt(0);

        input.removeIf(x->!isStartWithUpperCase.test(x));

        Consumer<String> print = s-> System.out.println(s);

        System.out.println(input.size());
        for (String s:input ) {
            print.accept(s);
        }

    }
}
