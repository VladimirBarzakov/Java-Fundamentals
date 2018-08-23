import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class CountSameValuesInArray {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = reader.readLine().split(" ");
        HashMap<String, Integer> counter = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!counter.containsKey(arr[i])){
                counter.put(arr[i],0);
            }
            counter.put(arr[i],counter.get(arr[i])+1);
        }
        for (String key: counter.keySet()) {
            System.out.printf("%s - %d times%n",key, counter.get(key));
        }
    }
}
