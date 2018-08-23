package p08_pet_clinics;

public class Pet {
    private String name;
    private int age;
    private String type;

    public Pet(String name, int age, String type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return String.format("%s %d %s",this.name, this.age,this.type);
    }
}
