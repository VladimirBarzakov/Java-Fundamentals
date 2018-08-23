package p05_security_system;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ScannerUIImpl scannerUI = new ScannerUIImpl(new Scanner(System.in));
        KeyCardCheckBase keyCardCheck = new KeyCardCheckBase(scannerUI);
        PinCodeCheckBase pinCodeCheck = new PinCodeCheckBase(scannerUI);
        SecurityManager manager = new SecurityManager(keyCardCheck, pinCodeCheck);
        manager.check();
    }
}
