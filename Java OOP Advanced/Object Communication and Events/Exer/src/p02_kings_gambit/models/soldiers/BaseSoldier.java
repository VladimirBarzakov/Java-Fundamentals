package p02_kings_gambit.models.soldiers;

import p02_kings_gambit.contracts.Soldier;

import java.util.Map;

public abstract class BaseSoldier implements Soldier {
    private String name;
    int hitPoints;
    private Map<String, Soldier> map;

    public BaseSoldier(String name, int hitPoints, Map<String, Soldier> map) {
        this.name = name;
        this.map = map;
        this.hitPoints=hitPoints;
    }

    @Override
    public String getName() {
        return this.name;
    }


    @Override
    public void takeDamage(){
        this.hitPoints--;
        if (this.hitPoints==0){
            this.map.remove(this.name);
        }
    }

    @Override
    public String respond(){
        return this.toString();
    }
}
