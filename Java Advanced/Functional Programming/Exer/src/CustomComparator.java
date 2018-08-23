import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;

public class CustomComparator {

    private static class MyComparator implements Comparator<Long> {
        public int compare(Long a, Long b){
            int comparator =0;
            boolean isAevan = a%2==0;
            boolean isBevan = b%2==0;
            if (isAevan && !isBevan){
                comparator=-1;
            } else if(!isAevan && isBevan){
                comparator=1;
            }
            if (comparator==0){
                comparator = a.compareTo(b);
            }
            return comparator;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Long[] arr = Arrays.stream(reader.readLine().split(" ")).mapToLong(Long::parseLong)
                .boxed().toArray(Long[]::new);

        Arrays.sort(arr,new MyComparator());

        Consumer<Long[]> printAll = l->{
            for (Long element:l) {
                System.out.printf("%d ",element);
            }
        };
        printAll.accept(arr);
    }
}
