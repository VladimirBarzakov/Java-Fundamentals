package models.appenders;

import contracts.Appender;
import contracts.Layout;
import models.dataHandlers.LogFile;
import models.ReportLevel;

public class FileAppender extends BaseAppender implements Appender {

    public FileAppender(Layout layout, ReportLevel reportLevel) {
        super(layout, reportLevel, new LogFile());
    }

}
