package models.loggers;

import contracts.Appender;
import contracts.Layout;
import contracts.Logger;
import factories.AppenderFactory;
import factories.LayoutFactory;

import java.util.ArrayList;
import java.util.List;

public class MessageLogger implements Logger {
    private List<Appender> appenders;
    private LayoutFactory layoutFactory;
    private AppenderFactory appenderFactory;

    public MessageLogger(LayoutFactory layoutFactory, AppenderFactory appenderFactory) {
        this.layoutFactory = layoutFactory;
        this.appenderFactory = appenderFactory;
        this.appenders = new ArrayList<>();
    }

    @Override
    public void processLog(String infoMessage) {
        String[] tokens = infoMessage.split("\\|");
        String reportLevel = tokens[0];
        String time = tokens[1];
        String message = tokens[2];
        for (Appender appender:this.appenders) {
            appender.appendMessage(time,reportLevel, message);
        }
    }

    @Override
    public void addAppender(String addAppenderCommands) {
        String[] tokens = addAppenderCommands.split("\\s+");
        String typeOfAppender = tokens[0];
        String typeOfLayout = tokens[1];
        Layout layout = this.layoutFactory.generateLayout(typeOfLayout);
        Appender appender;
        if (tokens.length==3){
            String reportLevel = tokens[2];
            appender=this.appenderFactory.
                    generateAppenderWithReportLevel(typeOfAppender,layout,reportLevel);
        } else{
            appender=this.appenderFactory.
                    generateAppenderWithDefaultReportLevel(typeOfAppender,layout);
        }
        this.appenders.add(appender);
    }

    @Override
    public String generateFullReport() {
        StringBuilder builder = new StringBuilder();
        builder.append("Logger info");
        for (Appender appender:this.appenders) {
            builder.append(System.lineSeparator()).append(appender.toString());
        }
        return builder.toString();
    }
}
