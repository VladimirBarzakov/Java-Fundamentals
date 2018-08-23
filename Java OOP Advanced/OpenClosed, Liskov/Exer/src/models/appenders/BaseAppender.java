package models.appenders;

import contracts.Appender;
import contracts.DataHandler;
import contracts.Layout;
import models.ReportLevel;

abstract class BaseAppender implements Appender {

    private Layout layout;
    private ReportLevel reportLevel;
    private DataHandler dataHandler;

    BaseAppender(Layout layout, ReportLevel reportLevel, DataHandler dataHandler) {
        this.layout = layout;
        this.reportLevel = reportLevel;
        this.dataHandler = dataHandler;
    }


    @Override
    public void appendMessage(String time, String reportLevelStr, String message) {
        ReportLevel reportLevel;
        try {
            reportLevel=ReportLevel.valueOf(reportLevelStr);
        } catch (IllegalArgumentException e){
            return;
        }
        if (this.reportLevel.ordinal()<=reportLevel.ordinal()){
            this.dataHandler.saveData(this.layout.generateMessageFromLogArgs(time,reportLevelStr,message));
        }
    }

    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, %s",
                this.getClass().getSimpleName(),
                this.layout.getClass().getSimpleName(),
                this.reportLevel.name(),
                this.dataHandler.toString());
    }
}
