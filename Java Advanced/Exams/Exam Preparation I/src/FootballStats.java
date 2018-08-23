import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class FootballStats {

    static class Team{
        private String name;
        private List<Match> matches;

        Team(String name) {
            this.name = name;
            this.matches = new ArrayList<>();
        }
    }

    static class Match{
        private String currentTeam;
        private Long currentResult;
        private String opponentTeam;
        private Long opponentResult;

        Match(String currentTeam, Long currentResult, String opponentTeam, Long opponentResult) {
            this.currentTeam = currentTeam;
            this.currentResult = currentResult;
            this.opponentTeam = opponentTeam;
            this.opponentResult = opponentResult;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Team> teams = new HashMap<>();

        String line;
        while (true){
            line=reader.readLine();
            if ("Season End".equals(line)){
                break;
            }
            String[] tokens = line.split("\\s+");
            String teamA = tokens[0];
            String teamB = tokens[2];
            tokens=tokens[4].split(":");
            Long resultA = Long.parseLong(tokens[0]);
            Long resultB = Long.parseLong(tokens[1]);
            if (!teams.containsKey(teamA)){
                teams.put(teamA,new Team(teamA));
            }
            if (!teams.containsKey(teamB)){
                teams.put(teamB,new Team(teamB));
            }
            teams.get(teamA).matches.add(new Match(teamA,resultA,teamB,resultB));
            teams.get(teamB).matches.add(new Match(teamB,resultB,teamA,resultA));
        }
        line=reader.readLine();
        String[] keyTeams = line.split(", ");
        for (String team:keyTeams) {
            List<Match> matches = teams.get(team).matches;
            for (Match match:matches.stream()
                    .sorted(Comparator.comparing(x -> x.opponentTeam))
                    .collect(Collectors.toList()) ) {
                System.out.printf("%s - %s -> %d:%d%n",
                        match.currentTeam,
                        match.opponentTeam,
                        match.currentResult,
                        match.opponentResult);
            }

        }

    }
}
