package model.colinists;

import model.baseColonist.Medic;

public class GeneralPractitioner extends Medic {
    private static final int GP_CLASS_BONUS=1;
    private static final int GP_HIGHER_AGE_BOUND=15;


    public GeneralPractitioner(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age, sign);
    }

    @Override
    public int getPotential() {
        int potential = super.getPotential();
        if (super.getAge()>GP_HIGHER_AGE_BOUND){
            potential+=GP_CLASS_BONUS;
        }
        switch (super.getSign()){
            case "caring":
                potential+=1;
                break;
            case "careless":
                potential+=-2;
                break;
        }
        return potential;
    }
}
