import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Genome {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Long> genes = new LinkedHashMap<>();
        Pattern pattern = Pattern.compile("^([\\!\\@\\#\\$\\?a-z]*)=([\\d]+)--([\\d]+)<<([a-z]+)$");
        String line;
        while (true){
            line=reader.readLine();
            if ("Stop!".equals(line)){
                break;
            }
            Matcher matcher=pattern.matcher(line);
            if (!matcher.find()){
                continue;
            }
            String name = matcher.group(1).replaceAll("[\\!\\@\\#\\$\\?]","");
            Long lenght = Long.parseLong(matcher.group(2));
            Long count = Long.parseLong(matcher.group(3));
            String organism = matcher.group(4);
            if (name.length()!=lenght){
                continue;
            }
            if (!genes.containsKey(organism)){
                genes.put(organism,0L);
            }
            genes.put(organism,genes.get(organism)+count);
        }
        for (String organism:genes.keySet().stream()
                .sorted((x,y)->genes.get(y).compareTo(genes.get(x)))
                .collect(Collectors.toCollection(LinkedHashSet::new))
             ) {
            System.out.printf("%s has genome size of %d%n",organism,genes.get(organism));
        }

    }
}
