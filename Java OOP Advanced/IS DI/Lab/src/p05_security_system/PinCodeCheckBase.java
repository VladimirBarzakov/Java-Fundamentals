package p05_security_system;

import p05_security_system.contracts.PinCodeUI;
import p05_security_system.contracts.ScannerUI;

public class PinCodeCheckBase extends BaseSecurityCheck implements PinCodeUI {

    public PinCodeCheckBase(ScannerUI scannerUI) {
        super(scannerUI);
    }

    @Override
    public boolean validateUser() {
        int pin = this.requestPinCode();
        return isValid(pin);

    }

    private boolean isValid(int pin) {
        return true;
    }

    @Override
    public int requestPinCode() {
        System.out.println("enter your pin code");
        return Integer.parseInt(super.getScannerUI().readLine());
    }
}
