package p03;

public class Coffee {
    private CoffeeSize size;
    private CoffeeType type;

    public Coffee(String size, String type) {
        this.size = CoffeeSize.valueOf(CoffeeSize.class, size.toUpperCase());
        this.type = CoffeeType.valueOf(CoffeeType.class, type.toUpperCase());
    }

    public CoffeeSize getSize() {
        return this.size;
    }

    public CoffeeType getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.size.toString(), this.type.toString());
    }
}
