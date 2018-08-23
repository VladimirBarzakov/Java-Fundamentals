package p04_work_force.models;

import p04_work_force.contracts.Observer;
import p04_work_force.contracts.Subject;

public class Job implements Observer {
    private String name;
    private int workRate;
    private Subject subject;
    private int remainingHours;

    public Job(String name, int requiredHours, int workRate, Subject subject) {
        this.name = name;
        this.remainingHours = requiredHours;
        this.workRate = workRate;
        this.subject = subject;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void update() {
        this.remainingHours -=this.workRate;
        if (this.remainingHours<=0){
            this.subject.notifySubjectHolder(this.name);
        }
    }

    public int getRemainingHours() {
        return this.remainingHours;
    }

    @Override
    public String toString() {
        return String.format("Job: %s Hours Remaining: %d",this.name, this.remainingHours);
    }
}
