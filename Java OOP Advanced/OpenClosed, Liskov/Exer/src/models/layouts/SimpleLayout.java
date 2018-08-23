package models.layouts;

import contracts.Layout;

public class SimpleLayout extends BaseLayout implements Layout {
    private static final String DEFAULT_LAYOUT = "%s - %s - %s";

    public SimpleLayout() {
        super(DEFAULT_LAYOUT);
    }
}
