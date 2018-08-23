package p02;

import java.text.DecimalFormat;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private Double salary;


    public Person() {
    }

    public Person(String firstName, String lastName, int age, Double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.length()<3){
            throw new IllegalArgumentException("Names must be at least 3 symbols");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.length()<3){
            throw new IllegalArgumentException("Names must be at least 3 symbols");
        }
        this.lastName = lastName;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if (age<=0){
            throw new IllegalArgumentException("Age must not be zero or negative");
        }
        this.age = age;
    }

    public Double getSalary() {
        return this.salary;
    }

    public void setSalary(Double salary) {
        if (salary<460){
            throw new IllegalArgumentException("Salary can't be less than 460.0");
        }
        this.salary = salary;
    }

    public void increaseSalary(Double bonus){
        if (this.age > 30) {
            this.salary += (this.salary * bonus / 100);
        } else {
            this.salary += (this.salary * bonus / 200);
        }

    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("0.0########");
        //return String.format("%s %s gets %s leva",
        //       this.firstName,
        //       this.lastName,
        //       format.format(this.salary));
        return this.firstName+" "+this.lastName+" gets "+this.salary+" leva";

    }
}