package p01;

public enum Weekday {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;


    @Override
    public String toString() {
        return super.toString().charAt(0)+super.toString().substring(1).toLowerCase();
    }
}
