package p04_work_force.models.workers;

import p04_work_force.contracts.Worker;

public abstract class BaseWorker implements Worker {
    private String name;
    private int workingHours;

    protected BaseWorker(String name, int workingHours) {
        this.name = name;
        this.workingHours = workingHours;
    }

    @Override
    public int getWorkingHours() {
        return this.workingHours;
    }
}
