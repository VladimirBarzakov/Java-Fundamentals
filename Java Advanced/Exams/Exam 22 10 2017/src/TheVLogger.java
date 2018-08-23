import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class TheVLogger {

    private static class VLogger{
        private String vloggername;

        private TreeSet<String> followers;
        private HashSet<String> following;

        VLogger(String vloggerName) {
            this.vloggername = vloggerName;
            this.followers = new TreeSet<>();
            this.following = new HashSet<>();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, VLogger> vLogger = new HashMap<>();
        String line;
        while (true){
            line=reader.readLine();
            if ("Statistics".equals(line)){
                break;
            }
            String[] tokens = line.split(" ");
            switch (tokens[1]){
                case "joined":
                    register(vLogger,tokens[0]);
                    break;
                case "followed":
                    addFollowed(vLogger,tokens[0],tokens[2]);
                    break;
            }
        }
        System.out.println(String.format("The V-Logger has a total of %d vloggers in its logs.",vLogger.size()));
        int index =1;
        for (String user:vLogger.keySet().stream().sorted((x,y)->{
            int comparator = vLogger.get(y).followers.size() - vLogger.get(x).followers.size();
            if (comparator==0){
                comparator = vLogger.get(x).following.size() - vLogger.get(y).following.size();
            }
            return comparator;
        }).collect(Collectors.toCollection(LinkedHashSet::new)) ) {
            System.out.printf("%d. %s : %d followers, %d following%n",index,user,
                    vLogger.get(user).followers.size(),
                    vLogger.get(user).following.size());
            if (index ==1){
                for (String follower:vLogger.get(user).followers ) {
                    System.out.printf("*  %s%n",follower);
                }
            }
            index++;
        }


    }

    private static void addFollowed(Map<String,VLogger> vLogger,
                                    String user,
                                    String toFollow) {
        if (!vLogger.containsKey(user) ||
                !vLogger.containsKey(toFollow) ||
                user.equals(toFollow)){
            return;
        }
        vLogger.get(user).following.add(toFollow);
        vLogger.get(toFollow).followers.add(user);
    }

    private static void register(Map<String,VLogger> vLogger,
                                 String guest) {
        if (!vLogger.containsKey(guest)){
            vLogger.put(guest,new VLogger(guest));
        }
    }
}
