package p06_animals;

public class Kitten extends Cat {
    public Kitten(String type, String name, int age, String gender) {
        super(type, name, age, gender);
    }

    @Override
    public void setGender(String gender) {
        if (!gender.equals("Female")) {
            throw new IllegalArgumentException();
        }
        super.setGender(gender);
    }

    @Override
    public String produceSound() {
        return "Miau";
    }
}
