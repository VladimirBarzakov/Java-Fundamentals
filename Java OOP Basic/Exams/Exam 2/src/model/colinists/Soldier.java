package model.colinists;

import model.Colonist;

public class Soldier extends Colonist {
    private static final int SOLDIER_CLASS_BONUS = 3;
    private static final int AGE_BONUS = 3;

    public Soldier(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    public int getPotential() {
        return super.getTalent()+ SOLDIER_CLASS_BONUS +AGE_BONUS;
    }
}
