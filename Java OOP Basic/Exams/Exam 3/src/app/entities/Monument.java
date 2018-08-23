package app.entities;

public abstract class Monument {
    private String name;

    public Monument(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public abstract String toString();

    public abstract int getMonumentPower();
}
