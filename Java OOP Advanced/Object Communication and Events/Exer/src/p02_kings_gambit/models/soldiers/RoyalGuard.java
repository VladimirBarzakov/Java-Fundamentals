package p02_kings_gambit.models.soldiers;

import java.util.Map;

public class RoyalGuard extends BaseSoldier{
    public RoyalGuard(String name,Map map) {
        super(name, 3, map);
    }

    @Override
    public String toString() {
        return String.format("Royal Guard %s is defending!",this.getName());
    }
}
