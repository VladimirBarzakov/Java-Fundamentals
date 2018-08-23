package p01_logger.command_pattern;

import p01_logger.contracts.Command;
import p01_logger.contracts.Executor;

public class CommandExecutor implements Executor {
    @Override
    public void executeCommand(Command command) {
        command.execute();
    }
}
