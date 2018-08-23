package p06to07_strategy_pattern;

public class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return String.format("%s %d",this.name, this.age);
    }

    @Override
    public int hashCode() {
        return this.age *this.name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        return this.getName().equals(((Person)obj).name) && this.age==((Person)obj).age;
    }

    @Override
    public int compareTo(Person o) {
        int comparator = this.getName().compareTo(o.name);
        if (comparator==0){
            comparator=Integer.compare(this.age,o.age);
        }
        return comparator;
    }
}
