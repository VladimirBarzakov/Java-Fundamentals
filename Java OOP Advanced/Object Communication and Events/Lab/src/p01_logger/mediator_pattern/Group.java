package p01_logger.mediator_pattern;

import p01_logger.contracts.AttackGroup;
import p01_logger.contracts.Attacker;
import p01_logger.contracts.Target;

import java.util.ArrayList;
import java.util.List;

public class Group implements AttackGroup {

    private List<Attacker> attackers;

    public Group() {
        this.attackers = new ArrayList<>();
    }

    @Override
    public void addMember(Attacker attacker) {
        this.attackers.add(attacker);
    }

    @Override
    public void groupTarget(Target target) {
        for (Attacker attacker : attackers) {
            attacker.setTarget(target);
        }
    }

    @Override
    public void groupAttack() {
        for (Attacker attacker : attackers) {
            attacker.attack();
        }
    }

    @Override
    public void groupTargetAndAttack(Target target) {
        for (Attacker attacker : attackers) {
            attacker.setTarget(target);
            attacker.attack();
        }
    }
}
