package app.entities.monuments;

import app.entities.Monument;

public class AirMonument extends Monument {
    private int airAffinity;
    public AirMonument(String name, int airAffinity) {
        super(name);
        this.airAffinity = airAffinity;
    }

    @Override
    public int getMonumentPower() {
        return this.airAffinity;
    }

    @Override
    public String toString() {
        return String.format("Air Monument: %s, Air Affinity: %d",super.getName(), this.airAffinity);
    }
}
