package models.layouts;

import contracts.Layout;

public class XmlLayout extends BaseLayout implements Layout {
    private static final String DEFAULT_LAYOUT =
            "<log>\n" +
            "   <date>%s</date>\n" +
            "   <level>%s</level>\n" +
            "   <message>%s</message>\n" +
            "</log>";

    public XmlLayout() {
        super(DEFAULT_LAYOUT);
    }
}
