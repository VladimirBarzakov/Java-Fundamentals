package model.baseColonist;

import model.Colonist;

public abstract class Engineer extends Colonist {
    private static final int ENGINEER_CLASS_BONUS = 3;
    private static final int AGE_BONUS = 2;
    private static final int AGE_LOWER_BOUND=30;

    public Engineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    public int getPotential() {
        int potential = super.getTalent()+ENGINEER_CLASS_BONUS;
        if (super.getAge()>AGE_LOWER_BOUND){
            potential+=AGE_BONUS;
        }
        return potential;
    }
}
