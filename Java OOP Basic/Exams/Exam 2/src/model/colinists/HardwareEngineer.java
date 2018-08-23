package model.colinists;

import model.baseColonist.Engineer;

public class HardwareEngineer extends Engineer {
    private static final int HARDWARE_ENGINEER_CLASS_BONUS =2;
    private static final int HARDWARE_ENGINEER_CLASS_AGE_HIGHER_BOUND =18;


    public HardwareEngineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    public int getPotential() {
        int potential = super.getPotential();
        if (super.getAge()<= HARDWARE_ENGINEER_CLASS_AGE_HIGHER_BOUND){
            potential+= HARDWARE_ENGINEER_CLASS_BONUS;
        }
        return potential;
    }
}
