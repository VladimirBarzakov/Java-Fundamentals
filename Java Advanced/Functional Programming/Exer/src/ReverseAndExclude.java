import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ReverseAndExclude {

    private static BufferedReader br;

    static {
        br=new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Long> nums = Arrays.stream(br.readLine().split("\\s+"))
                .mapToLong(Long::parseLong)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));


        Long n = Long.parseLong(br.readLine());

        nums.removeIf(x->x%n==0);
        Consumer<ArrayList<Long>> reverse = Collections::reverse;
        Consumer<ArrayList<Long>> print = x->{
            for (Long element:x) {
                System.out.printf("%d ",element);
            }
        };
        reverse.accept(nums);
        print.accept(nums);


    }
}
