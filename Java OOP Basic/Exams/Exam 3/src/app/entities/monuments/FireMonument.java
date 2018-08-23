package app.entities.monuments;

import app.entities.Monument;

public class FireMonument extends Monument {
    private int fireAffinity;
    public FireMonument(String name, int fireAffinity) {
        super(name);
        this.fireAffinity = fireAffinity;
    }

    @Override
    public int getMonumentPower() {
        return this.fireAffinity;
    }

    @Override
    public String toString() {
        return String.format("Fire Monument: %s, Fire Affinity: %d", super.getName(), this.fireAffinity);
    }
}
