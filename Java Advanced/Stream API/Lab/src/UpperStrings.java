import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UpperStrings {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] upperStrings = Arrays.stream(reader.readLine().split("\\s+"))
                .map(String::toUpperCase)
                .toArray(String[]::new);

        for (String str:upperStrings) {
            System.out.printf("%s ",str);
        }


    }
}
