package p11_cat_lady;

public class StreetExtraordinaire extends Cat {
    private double decibelsOfMeows;

    public StreetExtraordinaire(String type, String name, double decibelsOfMeows) {
        super(type, name);
        this.decibelsOfMeows = decibelsOfMeows;
    }

    @Override
    public String toString(){
        return String.format("%s %s %.2f",super.getType(), super.getName(), this.decibelsOfMeows);
    }
}
