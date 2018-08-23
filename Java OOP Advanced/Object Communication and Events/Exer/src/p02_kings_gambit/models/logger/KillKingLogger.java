package p02_kings_gambit.models.logger;

import p02_kings_gambit.contracts.Soldier;

import java.util.Map;

public class KillKingLogger extends BaseLogger {
    private Soldier king;

    public KillKingLogger(Map<String, Soldier> army, Soldier king) {
        super(army);
        this.king = king;
    }

    @Override
    public void handle(String message) {
        if ("Attack King".equals(message)){
            System.out.println(this.king.respond());
            for (Soldier soldier : super.getArmy().values()) {
                System.out.println(soldier.respond());
            }
        } else{
            super.passToSuccessor(message);
        }


    }
}
