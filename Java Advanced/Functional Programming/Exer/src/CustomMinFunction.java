import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomMinFunction {
    private static BufferedReader br;
    static {
        br=new BufferedReader(new InputStreamReader(System.in));
    }


    public static void main(String[] args) throws IOException {
        List<Integer> nums = Arrays.stream(br.readLine()
                .split("\\s+")).mapToInt(Integer::parseInt).boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        Function<List<Integer>, Integer> getMinNumber = (x)->{
          int minNum = Integer.MAX_VALUE;
            for (int i = 0; i < x.size(); i++) {
                if (minNum>x.get(i)){
                    minNum=x.get(i);
                }
            }
          return minNum;
        };

        System.out.println(getMinNumber.apply(nums));

    }
}
