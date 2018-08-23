package p06_foorball_team_generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens;
        Map<String, Team> teams = new HashMap<>();
        WhileLoop:
        while (true){
            tokens = reader.readLine().split(";");
            String teamName;
            Team team;
            try {
                switch (tokens[0]){
                    case "p06.Team":
                        teamName=tokens[1];
                        team = new Team(teamName);
                        teams.put(teamName,team);
                        break;
                    case "Add":
                        teamName=tokens[1];
                        String playerName = tokens[2];
                        team = getTeamOrThrowException(teams, teamName);
                        List<Integer> playerStats = Arrays.stream(tokens)
                                .skip(3)
                                .map(Integer::parseInt)
                                .collect(Collectors.toList());
                        Player player = new Player(playerName,playerStats);
                        team.addPlayer(player);
                        break;
                    case "Remove":
                        teamName=tokens[1];
                        playerName=tokens[2];
                        team = getTeamOrThrowException(teams, teamName);
                        if(!team.removePlayer(playerName)){
                            System.out.printf("p06.Player %s is not in %s team.%n", playerName, teamName);
                        }
                        break;
                    case "Rating":
                        teamName=tokens[1];
                        System.out.printf("%s - %.0f%n",teamName,teams.get(teamName).getTeamRating());
                        break;
                    case "END":
                        break WhileLoop;
                }
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            } catch (NullPointerException e){
                teamName=tokens[1];
                System.out.printf("p06.Team %s does not exist.%n",teamName);
            }

        }
    }

    private static Team getTeamOrThrowException(Map<String,Team> teams, String teamName) {
        Team team= teams.get(teamName);
        if (team==null){
            throw new NullPointerException();
        }
        return team;
    }
}
