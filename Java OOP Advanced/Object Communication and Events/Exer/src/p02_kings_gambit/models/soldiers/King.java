package p02_kings_gambit.models.soldiers;

import java.util.Map;

public class King extends BaseSoldier{
    public King(String name,Map map) {
        super(name, 0, map);
    }

    @Override
    public String toString() {
        return String.format("King %s is under attack!",this.getName());
    }
}
