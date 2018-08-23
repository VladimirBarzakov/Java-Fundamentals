package p09_google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private List<Pokemon> pokemons;
    private List<Parent> parents;
    private List<Child> children;
    private Car car;

    public Person() {
        this.pokemons=new ArrayList<>();
        this.parents=new ArrayList<>();
        this.children=new ArrayList<>();
    }

    public Person(String name) {
        this();
        this.name = name;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void addParent(Parent parent) {
        this.parents.add(parent);
    }

    public void addChild(Child child) {
        this.children.add(child);
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.name).append(System.lineSeparator());
        builder.append("p09_google.Company:").append(System.lineSeparator());
        if (this.company!=null){
            builder.append(this.company).append(System.lineSeparator());
        }
        builder.append("p09_google.Car:").append(System.lineSeparator());
        if (this.car!=null){
            builder.append(this.car).append(System.lineSeparator());
        }
        builder.append("p09_google.Pokemon:").append(System.lineSeparator());
        this.pokemons.forEach(x->builder.append(x).append(System.lineSeparator()));
        builder.append("Parents:").append(System.lineSeparator());
        this.parents.forEach(x->builder.append(x).append(System.lineSeparator()));
        builder.append("Children:").append(System.lineSeparator());
        this.children.forEach(x->builder.append(x).append(System.lineSeparator()));

        return builder.toString();
    }
}
