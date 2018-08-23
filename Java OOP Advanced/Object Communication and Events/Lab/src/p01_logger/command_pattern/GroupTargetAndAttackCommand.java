package p01_logger.command_pattern;

import p01_logger.contracts.AttackGroup;
import p01_logger.contracts.Command;
import p01_logger.contracts.Target;

public class GroupTargetAndAttackCommand implements Command {

    private AttackGroup attackGroup;
    private Target target;

    public GroupTargetAndAttackCommand(AttackGroup attackGroup, Target target) {
        this.attackGroup = attackGroup;
        this.target=target;
    }

    @Override
    public void execute() {
        this.attackGroup.groupTargetAndAttack(target);
    }
}
