package model.colinists;

import model.baseColonist.Medic;

public class Surgeon extends Medic {
    private static final int SURGEON_CLASS_BONUS =2;
    private static final int SURGEON_UPPER_AGE_BONUS =35;
    private static final int SURGEON_LOWER_AGE_BONUS =25;

    public Surgeon(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age, sign);
    }

    @Override
    public int getPotential() {
        int potential = super.getPotential();
        if (super.getAge()> SURGEON_LOWER_AGE_BONUS && super.getAge()< SURGEON_UPPER_AGE_BONUS){
            potential+= SURGEON_CLASS_BONUS;
        }
        switch (super.getSign()){
            case "precise":
                potential+=3;
                break;
            case "butcher":
                potential+=-3;
                break;
        }
        return potential;
    }
}
