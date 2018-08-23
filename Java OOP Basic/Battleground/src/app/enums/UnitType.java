package app.enums;

public enum UnitType {
    MARINE,
    CARRIER;

    @Override
    public String toString() {
        return this.name().replace(this.name().substring(1),
                this.name().substring(1).toLowerCase());
    }
}
