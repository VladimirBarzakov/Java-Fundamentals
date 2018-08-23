package p06_animals;

public class Frog extends Animal {
    public Frog(String type, String name, int age, String gender) {
        super(type, name, age, gender);
    }

    @Override
    public String produceSound() {
        return "Frogggg";
    }
}
