package rpg_lab;

import contracts.Weapon;

import java.util.List;
import java.util.Random;

public class Dummy implements contracts.Target {

    private int health;
    private int experience;
    private List<Weapon> possibleLoot;
    private boolean isLootCollected;

    public Dummy(int health, int experience, List<Weapon> possibleLoot) {
        this.health = health;
        this.experience = experience;
        if (possibleLoot ==null || possibleLoot.size()==0){
            throw new IllegalStateException("No loot declared!");
        }
        this.possibleLoot =possibleLoot;
        this.isLootCollected=false;
    }

    public Weapon giveLoot() {
        if (!this.isDead()) {
            throw new IllegalStateException("Dummy is not dead.");
        }
        if (this.isLootCollected) {
            throw new IllegalStateException("Loot already collected.");
        }
        Random random = new Random();
        int index = random.nextInt(this.possibleLoot.size());
        this.isLootCollected=true;
        return this.possibleLoot.get(index);
    }

    public int getHealth() {
        return this.health;
    }

    public void takeAttack(int attackPoints) {
        if (this.isDead()) {
            throw new IllegalStateException("Dummy is dead.");
        }

        this.health -= attackPoints;
    }

    public int giveExperience() {
        if (!this.isDead()) {
            throw new IllegalStateException("Target is not dead.");
        }
        return this.experience;
    }

    public boolean isDead() {
        return this.health <= 0;
    }
}
