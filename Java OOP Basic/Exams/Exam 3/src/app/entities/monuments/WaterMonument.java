package app.entities.monuments;

import app.entities.Monument;

public class WaterMonument extends Monument {
    private int waterAffinity;
    public WaterMonument(String name, int waterAffinity) {
        super(name);
        this.waterAffinity = waterAffinity;
    }

    @Override
    public int getMonumentPower() {
        return this.waterAffinity;
    }

    @Override
    public String toString() {
        return String.format("Water Monument: %s, Water Affinity: %d", super.getName(), this.waterAffinity);
    }
}
