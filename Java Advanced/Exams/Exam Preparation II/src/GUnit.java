import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GUnit {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String,Map<String,Set<String>>> testsDB = new LinkedHashMap<>();
        Pattern pattern = Pattern.compile("^([A-Z][A-Za-z\\d]{2,})\\s\\|\\s([A-Z][A-Za-z\\d]{2,})\\s\\|\\s([A-Z][A-Za-z\\d]{2,})$");
        String line;
        while (true){
            line=reader.readLine();
            if ("It's testing time!".equals(line)){
                break;
            }
            Matcher matcher = pattern.matcher(line);
            if (!matcher.find()){
                continue;
            }
            String clazz = matcher.group(1);
            String method = matcher.group(2);
            String unitTest = matcher.group(3);

            if (!testsDB.containsKey(clazz)){
                testsDB.put(clazz, new LinkedHashMap<>());
            }
            if (!testsDB.get(clazz).containsKey(method)){
                testsDB.get(clazz).put(method,new LinkedHashSet<>());
            }
            testsDB.get(clazz).get(method).add(unitTest);
        }

        testsDB.entrySet().stream().sorted((x,y)->{
            int sizeY = y.getValue().
                    values().stream().mapToInt(Set::size).sum();
            int sizeX = x.getValue().
                    values().stream().mapToInt(Set::size).sum();
            int comparator = sizeY - sizeX;
            if (comparator!=0){
                return comparator;
            }
            sizeY = y.getValue().size();
            sizeX = x.getValue().size();
            comparator=sizeX-sizeY;
            if (comparator!=0){
                return comparator;
            }
            return x.getKey().compareTo(y.getKey());
        }).forEach(x->{
            System.out.println(String.format("%s:",x.getKey()));
            x.getValue().entrySet().stream().sorted((m1,m2)->{
                int comparator = m2.getValue().size() - m1.getValue().size();
                if (comparator!=0){
                    return comparator;
                }
                return m1.getKey().compareTo(m2.getKey());
            }).forEach(m->{
                System.out.println(String.format("##%s",m.getKey()));
                m.getValue().stream().sorted((t1,t2)->{
                    int comparator = t1.length() - t2.length();
                    if (comparator!=0){
                        return comparator;
                    }
                    return t1.compareTo(t2);
                }).forEach(t-> System.out.println(String.format("####%s",t)));
            });
        });
    }
}
