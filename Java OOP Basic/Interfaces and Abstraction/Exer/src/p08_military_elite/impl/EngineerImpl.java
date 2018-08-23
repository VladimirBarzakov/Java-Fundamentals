package p08_military_elite.impl;

import p08_military_elite.interfaces.Engineer;
import p08_military_elite.interfaces.Repair;

import java.util.List;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {

    private List<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, String corps, List<Repair> repairs) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = repairs;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString()).append(System.lineSeparator());
        builder.append("Repairs:");
        for (Repair repair:this.repairs) {
            builder.append(System.lineSeparator()).append("  ").append(repair.toString());
        }
        return builder.toString();
    }
}
