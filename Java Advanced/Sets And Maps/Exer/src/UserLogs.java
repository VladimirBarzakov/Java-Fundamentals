
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class UserLogs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, LinkedHashMap<String, Integer>> userLogs = new HashMap<>();
        String line;

        while (!"end".equals(line=reader.readLine())){
            String[] tokens = line.split("=");
            String ip = tokens[1].substring(0,tokens[1].length()-8);
            String user = tokens[3].trim();
            if (!userLogs.containsKey(user)){
                userLogs.put(user, new LinkedHashMap<>());
            }
            if (!userLogs.get(user).containsKey(ip)){
                userLogs.get(user).put(ip,0);
            }
            userLogs.get(user).put(ip,userLogs.get(user).get(ip)+1);
        }

        for (String user: userLogs.keySet().stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new))) {
            System.out.println(user+": ");
            Iterator<String> ipIterator = userLogs.get(user).keySet().iterator();
            for (Iterator<String> it = ipIterator; it.hasNext(); ) {
                String ip = it.next();
                System.out.printf("%s => %d",ip,userLogs.get(user).get(ip));
                if (it.hasNext()){
                    System.out.print(", ");
                } else{
                    System.out.println(".");
                }

            }
        }
    }
}
