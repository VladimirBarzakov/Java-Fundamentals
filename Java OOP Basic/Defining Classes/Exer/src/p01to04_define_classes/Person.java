package p01to04_define_classes;

public class Person {

    private static final String DEFAULT_NAME = "No name";
    private static final int DEFAULT_AGE = 1;

    private String name = DEFAULT_NAME;
    private int age=DEFAULT_AGE;

    public Person() {
    }

    public Person(int age){
        this(DEFAULT_NAME,age);
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
