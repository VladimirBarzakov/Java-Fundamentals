package p04_work_force;

import p04_work_force.contracts.JobMap;
import p04_work_force.contracts.Worker;
import p04_work_force.models.Job;
import p04_work_force.models.JobMapImpl;
import p04_work_force.models.workers.PartTimeEmployee;
import p04_work_force.models.workers.StandartEmployee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        JobMap map = new JobMapImpl();
        Map<String, Worker> workers = new HashMap<>();
        String  line;
        while (true){
            line=reader.readLine();
            if ("End".equals(line)){
                break;
            }
            String[] tokens = line.split("\\s+");
            String command = tokens[0];
            switch (command){
                case "PartTimeEmployee":
                    workers.put(tokens[1], new PartTimeEmployee(tokens[1]));
                    break;
                case "StandartEmployee":
                    workers.put(tokens[1], new StandartEmployee(tokens[1]));
                    break;
                case "Job":
                    map.addJob(new Job(tokens[1], Integer.parseInt(tokens[2]), workers.get(tokens[3]).getWorkingHours(),map));
                    break;
                case "Pass":
                    map.notifyAllObservers();
                    break;
                case "Status":
                    for (Job job : map.getAll()) {
                        System.out.println(job.toString());
                    }
                    break;
            }
        }
    }
}
