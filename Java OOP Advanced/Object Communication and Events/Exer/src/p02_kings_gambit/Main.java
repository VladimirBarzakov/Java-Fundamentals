package p02_kings_gambit;

import p02_kings_gambit.contracts.Soldier;
import p02_kings_gambit.models.logger.KillKingLogger;
import p02_kings_gambit.models.logger.KillServentsLogger;
import p02_kings_gambit.models.soldiers.Footman;
import p02_kings_gambit.models.soldiers.King;
import p02_kings_gambit.models.soldiers.RoyalGuard;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Soldier> army = new LinkedHashMap<>();
        String line = scanner.nextLine();

        KillKingLogger logger = new KillKingLogger(army, new King(line,army));
        logger.setSuccessor(new KillServentsLogger(army));

        String[] tokens = scanner.nextLine().split("\\s+");
        for (String token : tokens) {
            army.put(token, new RoyalGuard(token,army));
        }
        tokens = scanner.nextLine().split("\\s+");
        for (String token : tokens) {
            army.put(token, new Footman(token,army));
        }
        while (true){
            line=scanner.nextLine();
            if ("End".equals(line)){
                break;
            }
            logger.handle(line);
        }

    }
}
