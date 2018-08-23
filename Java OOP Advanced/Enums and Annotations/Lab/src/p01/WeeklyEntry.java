package p01;

import java.util.Comparator;

public class WeeklyEntry{
    public final static Comparator<WeeklyEntry> BY_WEEKDAY = getCompByDay();
    private Weekday weekday;
    private String notes;

    public WeeklyEntry(String weekday, String notes) {
        this.weekday = Weekday.valueOf(Weekday.class,weekday.toUpperCase());
        this.notes = notes;
    }

    public Weekday getWeekday() {
        return this.weekday;
    }

    public String getNotes() {
        return this.notes;
    }

    private static Comparator<WeeklyEntry> getCompByDay() {
        return Comparator.comparing(WeeklyEntry::getWeekday);
    }

    @Override
    public String toString() {
        return String.format("%s - %s",this.weekday.toString(),this.notes);
    }
}
