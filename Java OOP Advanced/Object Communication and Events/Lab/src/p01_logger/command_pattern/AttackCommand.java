package p01_logger.command_pattern;

import p01_logger.contracts.Attacker;
import p01_logger.contracts.Command;

public class AttackCommand implements Command {
    private Attacker attacker;

    public AttackCommand(Attacker attacker) {
        this.attacker = attacker;
    }

    @Override
    public void execute() {
        attacker.attack();
    }
}
