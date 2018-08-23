package p04_work_force.models;

import p04_work_force.contracts.JobMap;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JobMapImpl implements JobMap {
    private Map<String, Job> map;
    private List<String> completedJobsToDelete;

    public JobMapImpl() {
        this.map=new LinkedHashMap<>();
        this.completedJobsToDelete = new ArrayList<>();
    }

    @Override
    public void addJob(Job job) {
        this.map.put(job.getName(),job);
    }

    @Override
    public Job getJob(String name) {
        return this.map.get(name);
    }

    @Override
    public Iterable<Job> getAll() {
        return this.map.values();
    }

    @Override
    public void notifyAllObservers() {
        for (Job job : this.map.values()) {
            job.update();
            if (job.getRemainingHours()<=0){
                this.completedJobsToDelete.add(job.getName());
            }
        }
        for (String name : this.completedJobsToDelete) {
            this.map.remove(name);
        }
        this.completedJobsToDelete.clear();

    }

    @Override
    public void notifySubjectHolder(String name) {
        this.completedJobsToDelete.add(name);
        System.out.println(String.format("Job %s done!",name));
    }
}
