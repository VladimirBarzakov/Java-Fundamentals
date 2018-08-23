package p01_logger.contracts;

import p01_logger.logger.LogType;

public interface Handler {
    void handle(LogType type, String message);
    void setSuccessor(Handler handler);

}
