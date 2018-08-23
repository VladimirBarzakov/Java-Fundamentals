package p01_logger.command_pattern;

import p01_logger.contracts.Attacker;
import p01_logger.contracts.Command;
import p01_logger.contracts.Target;

public class TargetCommand implements Command {
    private Attacker attacker;
    private Target target;

    public TargetCommand(Attacker attacker, Target target) {
        this.attacker = attacker;
        this.target = target;
    }

    @Override
    public void execute() {
        this.attacker.setTarget(target);
    }
}
