import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Character, Integer> counter = new TreeMap<>();
        String line = reader.readLine();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (!counter.containsKey(c)){
                counter.put(c,0);
            }
            counter.put(c,counter.get(c)+1);
        }
        for (char c: counter.keySet()) {
            System.out.printf("%c: %d time/s%n",c,counter.get(c));
        }
    }
}
