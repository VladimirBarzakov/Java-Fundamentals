package p01to04_define_classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(reader.readLine());
        Map<String, Department> departments = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String name = tokens[0];
            Double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];
            String email=null;
            Integer age=null;
            if (tokens.length==5){
                try {
                    age=Integer.parseInt(tokens[4]);
                } catch (Exception e){
                    email=tokens[4];
                }
            } else if(tokens.length==6){
                email=tokens[4];
                age=Integer.parseInt(tokens[5]);
            }
            if (!departments.containsKey(department)){
                departments.put(department, new Department(department));
            }
            Employee employee = new Employee(name,salary,position,department,email,age);
            departments.get(department).getEmployees().add(employee);
        }

        Optional<Map.Entry<String, Department>> highestAverageSalary = departments.entrySet().stream()
                .sorted((x, y) -> Double.compare(y.getValue().getAverageSalary(), x.getValue().getAverageSalary()))
                .limit(1).findFirst();
        if (highestAverageSalary.isPresent()){
            System.out.printf("Highest Average Salary: %s%n",highestAverageSalary.get().getKey());
            for (Employee employee:highestAverageSalary.get().getValue()
                    .getEmployees()
                    .stream()
                    .sorted((x,y)->Double.compare(y.getSalary(),x.getSalary()))
                    .collect(Collectors.toCollection(ArrayList::new))
                 ) {
                System.out.println(employee.toString());
            }
        }
    }
}
