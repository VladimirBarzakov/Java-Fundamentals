package p05_comparing_objects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getTown() {
        return this.town;
    }

    @Override
    public int compareTo(Person other) {
        int comparator = this.name.compareTo(other.name);
        if (comparator==0){
            comparator=Integer.compare(this.age, other.age);
        }
        if (comparator==0){
            comparator=this.town.compareTo(other.town);
        }
        return comparator;
    }
}
