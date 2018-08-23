import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class OfficeStuff {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<String, Long>> companies = new TreeMap<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(" - ");
            String company = tokens[0].substring(1);
            String product = tokens[2].substring(0,tokens[2].length()-1);
            Long quantity = Long.parseLong(tokens[1]);
            if (!companies.containsKey(company)){
                companies.put(company,new LinkedHashMap<>());
            }
            if (!companies.get(company).containsKey(product)){
                companies.get(company).put(product,0L);
            }
            companies.get(company).put(product,companies.get(company).get(product)+quantity);
        }
        for (String company:companies.keySet()) {
            System.out.printf("%s: ",company);
            StringBuilder builder = new StringBuilder();
            for (String product:companies.get(company).keySet()) {
                builder.append(String.format("%s-%d",product,companies.get(company).get(product)));
                builder.append(", ");
            }
            System.out.println(builder.toString().substring(0,builder.length()-2));

        }

    }
}
