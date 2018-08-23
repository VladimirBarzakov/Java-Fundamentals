import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Ranking {

    static class User {
        private String name;
        private Map<String, Contest> contest;

        public User(String name) {
            this.name = name;
            this.contest = new LinkedHashMap<>();
        }

        public int getAllPoints() {
            int res = 0;
            if (this.contest.isEmpty()) {
                return res;
            }
            for (Contest contest : this.contest.values()) {
                res += contest.points;
            }
            return res;
        }
    }

    static class Contest {
        private String name;
        private int points;

        public Contest(String name, int points) {
            this.name = name;
            this.points = points;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> contests = new HashMap<>();
        Map<String, User> users = new LinkedHashMap<>();
        String line;
        while (true) {
            line = reader.readLine();
            if ("end of contests".equals(line)) {
                break;
            }
            String[] tokens = line.split(":");
            contests.put(tokens[0], tokens[1]);
        }
        while (true) {
            line = reader.readLine();
            if ("end of submissions".equals(line)) {
                break;
            }
            String[] tokens = line.split("=>");
            String contest = tokens[0];
            String pass = tokens[1];
            String user = tokens[2];
            Integer points = Integer.parseInt(tokens[3]);
            if (!contests.containsKey(contest) || !contests.get(contest).equals(pass)) {
                continue;
            }
            if (!users.containsKey(user)) {
                User userOnj = new User(user);
                users.put(user, userOnj);
            }
            if (!users.get(user).contest.containsKey(contest)) {
                Contest contestObj = new Contest(contest, points);
                users.get(user).contest.put(contest, contestObj);
            } else {
                if (users.get(user).contest.get(contest).points < points) {
                    users.get(user).contest.get(contest).points = points;
                }
            }
        }

        Optional<String> candidateOpt = users.keySet().stream().min((x, y) -> users.get(y).getAllPoints() - users.get(x).getAllPoints());
        if (candidateOpt.isPresent()){
            System.out.printf("Best candidate is %s with total %d points.%n",
                    candidateOpt.get(), users.get(candidateOpt.get()).getAllPoints());
        } else{
            return;
        }

        System.out.println("Ranking:");
        for (String candidate : users.keySet().stream()
                .sorted(String::compareTo)
                .collect(Collectors.toCollection(LinkedHashSet::new))
                ) {
            System.out.println(candidate);
            for (Contest contest : users.get(candidate).contest
                    .values()
                    .stream()
                    .sorted((x, y) -> y.points - x.points)
                    .collect(Collectors.toCollection(LinkedHashSet::new))) {
                System.out.printf("#  %s -> %d%n", contest.name, contest.points);
            }
        }
    }
}
