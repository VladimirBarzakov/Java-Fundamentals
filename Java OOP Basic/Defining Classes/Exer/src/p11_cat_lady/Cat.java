package p11_cat_lady;

public abstract class Cat {
    private String type;
    private String name;

    public Cat() {
    }

    public Cat(String type, String name) {
        this.type = type;
        this.name=name;
    }

    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }
}
