package p06_foorball_team_generator;

import java.util.HashMap;
import java.util.Map;

public class Team {
    private String name;
    private Map<String, Player> players;

    private void setName(String name){
        if (name==null || name.isEmpty() || name.trim().isEmpty()){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name=name;
    }

    public Team(String name) {
        this.setName(name);
        this.players=new HashMap<>();
    }

    public void addPlayer(Player player){
        this.players.put(player.getName(),player);
    }

    public boolean removePlayer(String name){
        if (!this.players.containsKey(name)){
            return false;
        }
        this.players.remove(name);
        return true;
    }

    public double getTeamRating(){
        return this.players.values().stream().mapToInt(Player::getOverallSkill).average().orElse(0);
    }
}
