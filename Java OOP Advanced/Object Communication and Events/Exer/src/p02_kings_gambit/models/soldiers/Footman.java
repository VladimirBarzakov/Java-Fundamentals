package p02_kings_gambit.models.soldiers;

import java.util.Map;

public class Footman extends BaseSoldier {
    public Footman(String name, Map map) {
        super(name,  2, map);
    }

    @Override
    public String toString() {
        return String.format("Footman %s is panicking!",this.getName());
    }
}
