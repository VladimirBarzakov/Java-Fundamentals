package p08_military_elite.impl;

import p08_military_elite.interfaces.SpecialisedSoldier;

public class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {

    private static final String AIRFORCE_CORPS = "Airforces";
    private static final String MARINES_CORPS = "Marines";

    private String corps;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary);
        this.setCorps(corps);
    }

    private void setCorps(String corps) {
        if (!AIRFORCE_CORPS.equals(corps) && !MARINES_CORPS.equals(corps)){
            throw new IllegalArgumentException();
        }
        this.corps=corps;
    }

    @Override
    public String toString() {
        return String.format("%s%nCorps: %s",super.toString(), this.corps);
    }
}
