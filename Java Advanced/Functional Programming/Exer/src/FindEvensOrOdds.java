import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FindEvensOrOdds {
    private static BufferedReader br;

    static {
        br= new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        long[] nums = Arrays.stream(br.readLine().split("\\s+")).mapToLong(Long::parseLong).toArray();
        Long minBorder =nums[0];
        Long maxBorder = nums[1];
        String type = br.readLine();

        Predicate<Long> correctType = x->{
            boolean result = false;
          switch (type){
              case "odd":
                  result= x%2!=0;
                  break;
              case "even":
                  result= x%2==0;
              break;

          }
          return result;
        };
        BiFunction<Long, Long, List<Long>> getElements = (min, max)->{
          List<Long> list = new ArrayList<>();
            for (long i = minBorder; i <=maxBorder ; i++) {
                if (correctType.test(i)){
                    list.add(i);
                }
            }
          return list;
        };
        Consumer<Long> printElements = d-> System.out.print(String.format("%d ",d));
        List<Long> result = getElements.apply(minBorder,maxBorder);

        for (Long element:result) {
            printElements.accept(element);
        }

    }
}
