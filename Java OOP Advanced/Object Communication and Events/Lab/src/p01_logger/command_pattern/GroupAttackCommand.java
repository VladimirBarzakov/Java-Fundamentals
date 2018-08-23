package p01_logger.command_pattern;

import p01_logger.contracts.AttackGroup;
import p01_logger.contracts.Command;

public class GroupAttackCommand implements Command {
    private AttackGroup attackGroup;

    public GroupAttackCommand(AttackGroup attackGroup) {
        this.attackGroup = attackGroup;
    }

    @Override
    public void execute() {
        this.attackGroup.groupAttack();
    }
}
