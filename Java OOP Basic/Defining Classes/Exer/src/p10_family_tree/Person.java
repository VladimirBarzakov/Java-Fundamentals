package p10_family_tree;

import java.util.*;

public class Person {

    private static Map<String, Person> byBirthDate = new LinkedHashMap<>();
    private static Map<String, Person> byName = new LinkedHashMap<>();

    private String name;
    private String birthDate;

    private Set<Person> parents;
    private Set<Person> children;

    public Person() {
        this.parents=new LinkedHashSet<>();
        this.children = new LinkedHashSet<>();
    }

    public Person(String name, String birthDate) {
        this();
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (this.name!=null){
            Person.byName.remove(this.name);
        }
        this.name = name;
        Person.byName.put(name, this);

    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(String birthDate) {
        if (this.birthDate!=null){
            Person.byBirthDate.remove(this.birthDate);
        }
        this.birthDate = birthDate;
        Person.byBirthDate.put(birthDate, this);
    }

    public Set<Person> getParents() {
        return this.parents;
    }

    public Set<Person> getChildren() {
        return this.children;
    }

    public static Person getByBirthDate(String birthDate){
        return Person.byBirthDate.get(birthDate);
    }

    public static Person getByName(String name){
        return Person.byName.get(name);
    }

    public static void connectNameWithBirthDate(String name, String birthDate){
        Person personName = Person.getByName(name);
        Person personDate = Person.getByBirthDate(birthDate);
        if (personName==null && personDate==null){
            Person person = new Person();
            person.setBirthDate(birthDate);
            person.setName(name);
        } else if (personName==null && personDate!=null){
            personDate.setName(name);
        } else if (personName!=null && personDate==null){
            personName.setBirthDate(birthDate);
        } else{
            for (Person child:personDate.getChildren()) {
                personName.getChildren().add(child);
                child.getParents().add(personName);
                child.getParents().remove(personDate);
            }
            for (Person parent:personDate.getParents()) {
                personName.getParents().add(parent);
                parent.getChildren().add(personName);
                parent.getChildren().remove(personDate);
            }
            Person.byBirthDate.remove(birthDate);
            personName.setBirthDate(birthDate);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.name).append(" ").append(this.birthDate).append(System.lineSeparator());
        builder.append("Parents:").append(System.lineSeparator());
        for (Person parent:this.parents) {
            builder.append(parent.name).append(" ").append(parent.birthDate).append(System.lineSeparator());
        }
        builder.append("Children:").append(System.lineSeparator());
        for (Person child:this.children) {
            builder.append(child.name).append(" ").append(child.birthDate).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
