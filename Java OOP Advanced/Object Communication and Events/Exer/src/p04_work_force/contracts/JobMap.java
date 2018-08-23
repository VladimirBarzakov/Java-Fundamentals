package p04_work_force.contracts;

import p04_work_force.models.Job;

public interface JobMap extends Subject {
    void addJob(Job job);
    Job getJob(String name);
    Iterable<Job> getAll();
}
