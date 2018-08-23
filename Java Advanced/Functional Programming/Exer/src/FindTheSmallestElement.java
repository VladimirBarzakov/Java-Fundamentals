import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class FindTheSmallestElement {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        long[] nums = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToLong(Long::parseLong).toArray();

        Function<long[], Integer> getMinElement = x->{
          long minElement = Long.MAX_VALUE;
          int index=0;
            for (int i = 0; i < x.length; i++) {
                if (minElement>=x[i]){
                    minElement=x[i];
                    index=i;

                }
            }
          return index;
        };

        System.out.println(getMinElement.apply(nums));
    }
}
