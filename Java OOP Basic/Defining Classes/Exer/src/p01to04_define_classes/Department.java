package p01to04_define_classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Department {

    private String name;
    private List<Employee> employees;

    public Department() {
    }

    public Department(String name) {
        this.name = name;
        this.employees=new ArrayList<>();
    }

    public double getAverageSalary(){
        Optional<Double> averageSalary= this.employees.stream()
                .map(Employee::getSalary)
                .reduce((x, y)->x+y);
        return averageSalary.map(aDouble -> aDouble / employees.size()).orElse(0d);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
