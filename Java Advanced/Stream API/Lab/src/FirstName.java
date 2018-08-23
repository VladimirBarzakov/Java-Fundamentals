import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Collectors;

public class FirstName {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] names = reader.readLine().split("\\s+");

        HashSet<String> params = Arrays.stream(reader.readLine().split("\\s+"))
                .distinct().map(String::toLowerCase)
                .collect(Collectors.toCollection(HashSet::new));

        Optional<String> firstMatchName = Arrays.stream(names)
                .filter(x->!x.isEmpty() &&
                        params.contains(String.valueOf(x.charAt(0)).toLowerCase()))
                .sorted()
                .findFirst();

        if (firstMatchName.isPresent()){
            System.out.println(firstMatchName.get());
        } else{
            System.out.println("No match");
        }
    }
}
