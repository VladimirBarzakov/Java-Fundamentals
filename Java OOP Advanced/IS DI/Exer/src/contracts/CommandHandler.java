package contracts;

import java.util.List;

public interface CommandHandler {
    String executeCommand(String name, List<String> parameters);
}
