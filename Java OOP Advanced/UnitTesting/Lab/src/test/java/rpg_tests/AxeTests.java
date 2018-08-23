package rpg_tests;

import contracts.Weapon;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

import java.util.ArrayList;
import java.util.Collections;

public class AxeTests {
    public static final int WEAPON_ATTACK = 10;
    public static final int WEAPON_DURABILITY = 10;
    public static final int TARGET_HEALTH = 10;
    public static final int TARGET_XP = 10;
    public static final int EXPECTED_DURABILITY = WEAPON_DURABILITY -1;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void initializeTestObjects(){
        this.axe=new Axe(WEAPON_ATTACK, WEAPON_DURABILITY);
        this.dummy = new Dummy(TARGET_HEALTH, TARGET_XP, new ArrayList<Weapon>(Collections.singleton(this.axe)));
    }

    @Test
    public void weaponAttackLossesDurability(){
        this.axe.attack(this.dummy);
        Assert.assertEquals("Wrong Durability",9,axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void brokenWeaponCantAttack(){
        this.axe.attack(this.dummy);
        this.axe.attack(this.dummy);
    }
}
