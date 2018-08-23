package p05_security_system;

import p05_security_system.contracts.KeyCardUI;
import p05_security_system.contracts.PinCodeUI;
import p05_security_system.contracts.SecurityCheck;

import java.util.Scanner;

public class SecurityManager {

    private SecurityCheck keyCardCheck;
    private SecurityCheck pinCodeCheck;

    public SecurityManager(KeyCardUI keyCardCheck, PinCodeUI pinCodeCheck) {
        this.keyCardCheck = keyCardCheck;
        this.pinCodeCheck = pinCodeCheck;
    }

    public void check() {
        Scanner scanner = new Scanner(System.in);
        int option = Integer.parseInt(scanner.nextLine());
        switch (option) {
            case 1:
                System.out.println(keyCardCheck.validateUser());
                break;
            case 2:
                System.out.println(pinCodeCheck.validateUser());
                break;
        }
    }


}
