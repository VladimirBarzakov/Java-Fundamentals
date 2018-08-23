package app.models.spells;

public abstract class BaseSpell {
    private int damage;
    private int energyCost;

    protected BaseSpell(int damage, int energyCost) {
        this.damage = damage;
        this.energyCost = energyCost;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getEnergyCost() {
        return this.energyCost;
    }
}
