package p03_employee_info;

import p03_employee_info.contracts.ConsoleClient;
import p03_employee_info.contracts.Database;
import p03_employee_info.contracts.Formatter;
import p03_employee_info.contracts.InfoProvider;

public class Main {

    public static void main(String[] args) {
        Formatter formatter = new ConsoleFormatter();
        Database employeeDatabase = new EmployeeDatabase();
        InfoProvider employeeInfo = new EmployeeInfoProvider(employeeDatabase);
        ConsoleClient consoleClient = new ConsoleClientImpl(employeeInfo,formatter);
        consoleClient.run();
    }
}
