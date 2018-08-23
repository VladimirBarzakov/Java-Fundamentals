package p08_military_elite.impl;

import p08_military_elite.interfaces.Repair;

public class RepairImpl implements Repair {
    private String partName;
    private int hoursWorked;

    public RepairImpl(String partName, int partNumber) {
        this.partName = partName;
        this.hoursWorked = partNumber;
    }


    @Override
    public String toString() {
        return String.format("Part Name: %s Hours Worked: %d",this.partName, this.hoursWorked);
    }
}
