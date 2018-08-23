package p01_logger;

import p01_logger.command_pattern.*;
import p01_logger.contracts.*;
import p01_logger.logger.*;
import p01_logger.mediator_pattern.Group;
import p01_logger.models.Dragon;
import p01_logger.models.Warrior;

public class Main {
    public static void main(String[] args) {
        Logger combatLog = new CombatLogger();
        Logger errorLog = new ErrorLogger();
        Logger eventLog = new EventLogger();

        combatLog.setSuccessor(eventLog);
        eventLog.setSuccessor(errorLog);

        AttackGroup attackGroup = new Group();
        attackGroup.addMember(new Warrior("Warrior", 10, combatLog));
        attackGroup.addMember(new Warrior("ElderWarrior", 13, combatLog));

        Target dragon = new Dragon("Dragon", 100, 25, combatLog);
        Executor executor = new CommandExecutor();


        Command groupTarget = new GroupTargetCommand(attackGroup, dragon);
        Command groupAttack = new GroupAttackCommand(attackGroup);
        executor.executeCommand(groupTarget);
        executor.executeCommand(groupAttack);

    }
}
