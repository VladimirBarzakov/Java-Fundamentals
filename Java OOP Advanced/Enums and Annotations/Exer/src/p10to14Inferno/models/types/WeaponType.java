package p10to14Inferno.models.types;

public enum WeaponType {
    AXE(5,10,4),
    SWORD(4,6,3),
    KNIFE(3,4,2);

    private int minDamage;
    private int maxDamage;
    private int numOfSocket;

    WeaponType(int minDamage, int maxDamage, int numOfSocket) {
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.numOfSocket = numOfSocket;
    }

    public int getMinDamage() {
        return this.minDamage;
    }

    public int getMaxDamage() {
        return this.maxDamage;
    }

    public int getNumOfSocket() {
        return this.numOfSocket;
    }
}
