package models.appenders;

import contracts.Appender;
import contracts.Layout;
import models.dataHandlers.ConsoleDataHandler;
import models.ReportLevel;

public class ConsoleAppender extends BaseAppender implements Appender {
    private ConsoleDataHandler dataHandler;
    public ConsoleAppender(Layout layout, ReportLevel reportLevel) {
        super(layout, reportLevel, new ConsoleDataHandler());
    }

}
