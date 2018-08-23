package p03_man_kind;

public class Worker extends Human {
    private double weekSalary;
    private int workHoursPayDay;

    public Worker(String firstName, String lastName, double weekSalary, int workHoursPayDay) {
        super(firstName, lastName);
        this.weekSalary = weekSalary;
        this.workHoursPayDay = workHoursPayDay;
    }

    public void setWeekSalary(double weekSalary) {
        if (weekSalary<10){
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    public void setWorkHoursPayDay(int workHoursPayDay) {
        if (workHoursPayDay<1 || workHoursPayDay>12){
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workHoursPayDay = workHoursPayDay;
    }

    public double getSalaryPerHour(){
        return this.weekSalary/(this.workHoursPayDay*7);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString()).append(System.lineSeparator());
        builder.append(String.format("Week Salary: %.2f",this.weekSalary)).append(System.lineSeparator());
        builder.append(String.format("Hours per day: %d",this.workHoursPayDay)).append(System.lineSeparator());
        builder.append(String.format("Salary per hour: %.2f",this.getSalaryPerHour()));
        return builder.toString();


    }
}
