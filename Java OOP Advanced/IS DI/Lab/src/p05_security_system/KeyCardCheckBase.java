package p05_security_system;

import p05_security_system.contracts.KeyCardUI;
import p05_security_system.contracts.ScannerUI;

public class KeyCardCheckBase extends BaseSecurityCheck implements KeyCardUI {

    public KeyCardCheckBase(ScannerUI scannerUI) {
        super(scannerUI);
    }

    @Override
    public boolean validateUser() {
        String code = this.requestKeyCard();
        return isValid(code);

    }

    private boolean isValid(String code) {
        return true;
    }


    @Override
    public String requestKeyCard() {
        System.out.println("slide your key card");
        return super.getScannerUI().readLine();
    }
}
