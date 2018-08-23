import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class LogsAggregator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        HashMap<String, HashSet<String>> usersIps = new HashMap<>();
        HashMap<String, Long> usersDuration = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(" ");
            String ip = tokens[0];
            String user = tokens[1];
            Long duration = Long.parseLong(tokens[2]);
            if (!usersIps.containsKey(user)){
                usersIps.put(user, new HashSet<>());
                usersDuration.put(user,0L);
            }
            usersIps.get(user).add(ip);
            usersDuration.put(user,usersDuration.get(user)+duration);
        }
        for (String user:usersIps.keySet().stream().sorted(String::compareTo)
                .collect(Collectors.toCollection(LinkedHashSet::new))) {
            System.out.printf("%s: %d ",user,usersDuration.get(user));
            String[] result = Arrays.stream(usersIps.get(user).toArray(new String[usersIps.get(user).size()])).sorted(String::compareTo).map(Object::toString).toArray(String[]::new);
            System.out.println(Arrays.toString(result));
        }
    }
}
