package rpg_tests;

import contracts.Target;
import contracts.Weapon;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.Axe;
import rpg_lab.Dummy;
import rpg_lab.Hero;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static rpg_tests.AxeTests.*;

public class HeroTests {

    public static final String HERO_NAME = "HERO_NAME";

    @Test
    public void attackGainsExperienceIfTargetIsDead(){
        Target targetMock = Mockito.mock(Target.class);
        Weapon weaponMock = Mockito.mock(Weapon.class);
        Mockito.when(targetMock.isDead()).thenReturn(true);
        Mockito.when(targetMock.giveExperience()).thenReturn(TARGET_XP);

        Hero hero = new Hero(HERO_NAME, weaponMock);
        hero.attack(targetMock);
        Assert.assertEquals("Wrong experience", TARGET_XP, hero.getExperience());
    }

    @Test
    public void killedTargetShouldGiveLoot(){
        List<Weapon> possibleLoot = new ArrayList<Weapon>();
        for (int i = 0; i < 10; i++) {
            possibleLoot.add(new Axe(WEAPON_ATTACK, WEAPON_DURABILITY));
        }
        Dummy dummy = new Dummy(TARGET_HEALTH, TARGET_XP, possibleLoot);
        Weapon weapon = new Axe(WEAPON_ATTACK, WEAPON_DURABILITY);
        Hero hero  = new Hero(HERO_NAME, weapon);
        hero.attack(dummy);
        Weapon loot = dummy.giveLoot();
        List<Weapon> test = new ArrayList<Weapon>(Collections.singleton(loot));
        hero.collectLoot(loot);
        int counter =0;
        for (Weapon weapon1 :hero.getInventory()) {
            Assert.assertTrue(weapon1==test.get(counter++));
        }

    }
}