import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ListOfPredicates {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        Long[] dividers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToLong(Long::parseLong)
                .boxed()
                .toArray(Long[]::new);
        Predicate<Integer> isDivisible = x->{
          boolean isDivToAll =true;
            for (Long elem:dividers  ) {
                if (x %elem!=0){
                    isDivToAll=false;
                    break;
                }
            }
          return isDivToAll;
        };
        Function<Integer, List<Integer>> getAllNums = x->{
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <=x ; i++) {
                if (isDivisible.test(i)){
                    list.add(i);
                }
            }
            return list;
        };
        List<Integer> result= getAllNums.apply(n);

        for (Integer el:result) {
            System.out.printf("%d ",el);
        }
    }
}
