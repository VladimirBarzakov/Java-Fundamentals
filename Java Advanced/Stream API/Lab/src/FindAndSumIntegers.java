import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalLong;

public class FindAndSumIntegers {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        OptionalLong result = Arrays.stream(reader.readLine().split("\\s+")).filter(x->{
            try {
                Long.parseLong(x);
                return true;
            } catch (Exception e) {
                return false;
            }
        }).mapToLong(Long::parseLong).reduce((x,y)->x+y);

        if (result.isPresent()){
            System.out.println(result.getAsLong());
        } else{
            System.out.println("No match");
        }
    }
}
