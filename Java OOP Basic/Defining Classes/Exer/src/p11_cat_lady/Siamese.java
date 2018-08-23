package p11_cat_lady;

public class Siamese extends Cat{

    private double earSize;

    public Siamese(String type, String name, double earSize) {
        super(type, name);
        this.earSize = earSize;
    }

    @Override
    public String toString(){
        return String.format("%s %s %.2f",super.getType(), super.getName(), this.earSize);
    }
}
