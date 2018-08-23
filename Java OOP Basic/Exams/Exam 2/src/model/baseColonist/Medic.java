package model.baseColonist;

import model.Colonist;

public abstract class Medic extends Colonist {
    private static final int MEDIC_CLASS_BONUS=2;

    private String sign;

    public Medic(String id, String familyId, int talent, int age,String sign) {
        super(id, familyId, talent, age);
        this.sign=sign;
    }

    public String getSign() {
        return this.sign;
    }

    @Override
    public int getPotential() {
        return super.getTalent()+MEDIC_CLASS_BONUS;
    }


}
