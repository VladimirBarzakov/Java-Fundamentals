package contracts;

public interface Logger {
    void processLog(String infoMessage);
    void addAppender(String addAppenderCommands);
    String generateFullReport();
}
