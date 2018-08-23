package p05_security_system;

import p05_security_system.contracts.ScannerUI;

import java.util.Scanner;

public class ScannerUIImpl implements ScannerUI {

    private Scanner scanner;

    public ScannerUIImpl(Scanner scanner) {
        this.scanner = scanner;
    }





    @Override
    public String readLine() {
        return this.scanner.nextLine();
    }
}
