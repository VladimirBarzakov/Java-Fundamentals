package p06_animals;

public class Cat extends Animal {
    public Cat(String type, String name, int age, String gender) {
        super(type, name, age, gender);
    }

    @Override
    public String produceSound() {
        return "MiauMiau";
    }
}
