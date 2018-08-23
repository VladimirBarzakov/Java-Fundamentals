package factories;

import contracts.Appender;
import contracts.Layout;
import models.ReportLevel;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static constants.IOConstants.DEFAULT_REPORT_LEVEL;

public class AppenderFactory {
    private final String PATH = "models.appenders";

    public AppenderFactory() {
    }

    public final Appender generateAppenderWithReportLevel(String type, Layout layout, String reportLevelStr){
        ReportLevel reportLevel = null;
        try {
            reportLevel=ReportLevel.valueOf(reportLevelStr);
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        Appender appender;
        Constructor<?> constructor = getConstructor(type);
        appender = generateAppenderFromConstructor(layout, reportLevel, constructor);
        return appender;
    }

    public final Appender generateAppenderWithDefaultReportLevel(String type, Layout layout){
        Appender appender;
        Constructor<?> constructor = getConstructor(type);
        appender = generateAppenderFromConstructor(layout, DEFAULT_REPORT_LEVEL, constructor);
        return appender;
    }

    private Appender generateAppenderFromConstructor(Layout layout, ReportLevel defaultReportLevel, Constructor<?> constructor) {
        Appender appender = null;
        try {
            appender = (Appender) constructor.newInstance(layout, defaultReportLevel);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return appender;
    }

    private Constructor getConstructor(String type) {
        Constructor<?> constructor = null;
        try {
            Class<?> clazz = Class.forName(PATH+"."+type);
            constructor = clazz.getDeclaredConstructor(
                    Layout.class, ReportLevel.class);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return constructor;
    }
}
