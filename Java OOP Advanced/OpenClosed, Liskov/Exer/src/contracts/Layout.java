package contracts;

import java.io.IOException;

public interface Layout {
    String generateMessageFromLogArgs(String time, String reportLevel, String message);
}
