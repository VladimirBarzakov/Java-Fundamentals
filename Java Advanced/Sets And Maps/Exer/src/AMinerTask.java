import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashSet;

public class AMinerTask {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,Long> elements = new HashMap<>();
        LinkedHashSet<String> orderedElements = new LinkedHashSet<>();

        while (true){
            String line = reader.readLine();
            if ("stop".equals(line)){
                break;
            }
            orderedElements.add(line);
            long quantity = Long.parseLong(reader.readLine());
            if (!elements.containsKey(line)){
                elements.put(line,0L);
            }
            elements.put(line,elements.get(line)+quantity);
        }
        for (String element: orderedElements) {
            System.out.printf("%s -> %d%n",element,elements.get(element));
        }
    }
}
