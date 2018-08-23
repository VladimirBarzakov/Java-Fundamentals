package p02_kings_gambit.models.logger;

import p02_kings_gambit.contracts.Soldier;

import java.util.Map;

public class KillServentsLogger extends BaseLogger {
    public KillServentsLogger(Map<String, Soldier> army) {
        super(army);
    }

    @Override
    public void handle(String message) {
        String name = message.split("\\s+")[1];
        super.getArmy().get(name).takeDamage();
    }
}
