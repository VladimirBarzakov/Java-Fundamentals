package models.layouts;

import contracts.Layout;


public abstract class BaseLayout implements Layout {

    private String defaultLayout;

    BaseLayout(String defaultLayout) {
        this.defaultLayout = defaultLayout;
    }

    @Override
    public String generateMessageFromLogArgs(String  time, String reportLevel, String message) {
        return String.format(defaultLayout, time, reportLevel, message);
    }
}
