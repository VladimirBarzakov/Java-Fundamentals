package contracts;

public interface Target {
    Weapon giveLoot();

    int getHealth();

    void takeAttack(int attackPoints);

    int giveExperience();

    boolean isDead();
}
