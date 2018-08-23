import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SetsOfElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashSet<String> a = new LinkedHashSet<>();
        LinkedHashSet<String> b = new LinkedHashSet<>();

        int[] nums = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int n = nums[0];
        int m = nums[1];

        for (int i = 0; i < n; i++) {
            a.add(reader.readLine());
        }
        for (int i = 0; i < m; i++) {
            b.add(reader.readLine());
        }
        for (String element:a) {
            if (b.contains(element)){
                System.out.print(element+" ");
            }
        }
    }
}
