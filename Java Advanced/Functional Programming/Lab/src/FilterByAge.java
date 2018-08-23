import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge {

    private static BufferedReader br;
    private static LinkedHashMap<String, Integer> people;
    static {
        br=new BufferedReader(new InputStreamReader(System.in));
        people = new LinkedHashMap<>();
    }

    public static void main(String[] args) throws IOException {
        int n =Integer.parseInt(br.readLine());
        String[] tokens;
        for (int i = 0; i < n; i++) {
            tokens=br.readLine().split(", ");
            people.putIfAbsent(tokens[0],Integer.parseInt(tokens[1]));
        }
        String ageCondition = br.readLine();
        int ageBorder = Integer.parseInt(br.readLine());
        String format = br.readLine();

        Predicate<Integer> isOlder = x->x>=ageBorder;
        Consumer<Map.Entry<String, Integer>> printFormat = x->{
          switch (format){
              case "name":
                  System.out.println(x.getKey());
                  break;
              case "age":
                  System.out.println(x.getValue());
                  break;
              case "name age":
                  System.out.printf("%s - %d%n",x.getKey(),x.getValue());
                  break;
          }
        };

        for (Map.Entry<String, Integer> pair:people.entrySet()) {
            if ("older".equals(ageCondition)){
                if (isOlder.test(pair.getValue())){
                    printFormat.accept(pair);
                }
            } else{
                if (!isOlder.test(pair.getValue())){
                    printFormat.accept(pair);
                }
            }
        }
    }
}
