import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class FixEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> bannedDomanin = new HashSet<>(Arrays.asList("us", "uk", "com"));
        HashMap<String, String> personAndMails = new HashMap<>();
        LinkedHashSet<String> users = new LinkedHashSet<>();
        String line;
        while (true){
            line = reader.readLine();
            if ("stop".equals(line)){
                break;
            }
            String email = reader.readLine();
            if (bannedDomanin.contains(email.substring(email.length()-2).toLowerCase()) ||
                    bannedDomanin.contains(email.substring(email.length()-3).toLowerCase())){
                continue;
            }
            personAndMails.put(line, email);
            users.add(line);
        }
        for (String user: users) {
            System.out.printf("%s -> %s%n",user,personAndMails.get(user));
        }
    }
}
