import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class PeriodicTable {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> elements = new HashSet<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] arr = reader.readLine().split(" ");
            elements.addAll(Arrays.asList(arr));
        }
        elements.stream().sorted().forEach(x-> System.out.printf("%s ",x));
    }
}
