package p01_system_resources;

import java.time.LocalTime;

public class GreetingClock {

    private TimeProvider timeProvider;
    private Writer writer;

    public GreetingClock(TimeProvider timeProvider, Writer writer) {
        this.timeProvider=timeProvider;
        this.writer=writer;
    }

    public void greeting() {
        if (timeProvider.getHour() < 12) {
            writer.println("Good morning...");
        } else if (timeProvider.getHour() < 18) {
            writer.println("Good afternoon...");
        } else {
            writer.println("Good evening...");
        }
    }
}
