package p06_foorball_team_generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {
    private static final List<String> PLAYER_STATS = new ArrayList<String>(){{
        add("Endurance");
        add("Sprint");
        add("Dribble");
        add("Passing");
        add("Shooting");
    }};
    private String name;
    private int[] stats;

    public Player(String name, List<Integer> stats) {
        this.setName(name);
        this.setStats(stats);
    }

    private void setStats(List<Integer> stats){
        if (stats.size()!= PLAYER_STATS.size()){
            throw new IllegalArgumentException();
        }
        int[] playerStats = new int[PLAYER_STATS.size()];
        for (int i = 0; i < stats.size(); i++) {
            if (stats.get(i)<0|| stats.get(i)>100){
                throw new IllegalArgumentException(String.format("%s should be between 0 and 100.",PLAYER_STATS.get(i)));
            }
            playerStats[i]=stats.get(i);
        }
        this.stats=playerStats;
    }

    private void setName(String name){
        if (name==null || name.isEmpty() || name.trim().isEmpty()){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name=name;
    }

    public Integer getOverallSkill(){
        return (int)Math.round(Arrays.stream(this.stats).average().orElse(0));
    }

    public String getName() {
        return this.name;
    }
}
