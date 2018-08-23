package rpg_tests;

import contracts.Weapon;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

import java.util.ArrayList;
import java.util.Collections;

import static rpg_tests.AxeTests.*;

public class DummyTests {

    private Axe axe;
    private Dummy dummy;
    public static final int EXPECTED_HEALTH = TARGET_HEALTH-WEAPON_ATTACK;

    @Before
    public void initializeTestObjects(){
        this.axe=new Axe(WEAPON_ATTACK, WEAPON_DURABILITY);
        this.dummy = new Dummy(TARGET_HEALTH, TARGET_XP, new ArrayList<Weapon>(Collections.singleton(this.axe)));
    }

    @Test
    public void dummyLosesHealthIfAttacked(){
        this.axe.attack(this.dummy);
        Assert.assertEquals("Wrong Health",EXPECTED_HEALTH, this.dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyThrowsExceptionIfAttacked(){
        this.axe.attack(this.dummy);
        this.axe.attack(this.dummy);
    }

    @Test
    public void deadDummyGiveXP(){
        this.axe.attack(this.dummy);
        Assert.assertEquals("Wrong XP",TARGET_XP, this.dummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDummyCantGiveXP(){
        this.dummy.giveExperience();
    }

}
