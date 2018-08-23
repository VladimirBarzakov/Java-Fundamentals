package p03_employee_info;

import p03_employee_info.contracts.ConsoleClient;
import p03_employee_info.contracts.Formatter;
import p03_employee_info.contracts.InfoProvider;

public class ConsoleClientImpl implements ConsoleClient {
    private InfoProvider infoProvider;
    private Formatter formatter;

    public ConsoleClientImpl(InfoProvider infoProvider, Formatter formatter) {
        this.infoProvider = infoProvider;
        this.formatter = formatter;
    }

    @Override
    public void run() {
        String output = formatter.format(infoProvider.getEmployeesByName());
        System.out.println(output);
    }
}
