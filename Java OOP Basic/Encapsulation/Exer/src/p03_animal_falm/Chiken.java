package p03_animal_falm;

public class Chiken {
    private String name;
    private int age;



    public Chiken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    private void setName(String name){
        if (name.length()<1 || name.trim().length()<1){
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name=name;
    }

    private void setAge(int age){
        if (age<0 || age>15){
            throw  new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age=age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    private double calculateProductPerDay(){
        if (this.age>=0 && this.age<=5){
            return 2d;
        } else if (this.age>=6 && this.age<=11){
            return 1d;
        } else if(this.age>=12 && this.age<=15){
            return 0.75d;
        }
        return 0;
    }

    public double productPerDay(){
        return this.calculateProductPerDay();
    }
}
