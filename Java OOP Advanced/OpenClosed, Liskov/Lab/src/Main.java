import P04_DetailPrinter.DetailsPrinter;
import P04_DetailPrinter.Employee;
import P04_DetailPrinter.Manager;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Employee employee  =new Employee("Vlado");
        List<String> docs = new ArrayList<String>(){{
            add("Docs 1");
            add("Docs 2");
            add("Docs 3");
        }};
        Manager manager = new Manager("Elitsa", docs);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        employees.add(manager);
        DetailsPrinter printer = new DetailsPrinter(employees);
        printer.printDetails();
    }
}
