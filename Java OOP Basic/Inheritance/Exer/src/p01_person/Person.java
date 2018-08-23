package p01_person;

public class Person {
    private int age;
    private String name;

    public Person(String name,int age) {
        this.setName(name);
        this.setAge(age);
    }

    protected void setAge(int age) {
        if (age<0){
            throw new IllegalArgumentException("Age must be positive!");
        }
        this.age = age;
    }

    public final void setName(String name) {
        if (name==null || name.isEmpty() || name.length()<3){
            throw  new IllegalArgumentException("Name's length should not be less than 3 symbols!");
        }
        this.name = name;
    }

    @Override
    public final String toString() {
        return String.format("Name: %s, Age: %d",this.name, this.age);
    }
}
