package p06_animals;

public class Animal {

    private String type;
    private String name;
    private int age;
    private String gender;

    public Animal(String type, String name, int age, String gender) {
        this.setType(type);
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        if (name==null || name.trim().length()==0){
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age<0){
            throw new IllegalArgumentException();
        }
        this.age = age;
    }

    public void setGender(String gender) {
        if (gender==null || (!gender.equals("Male") && !gender.equals("Female"))){
            throw new IllegalArgumentException();
        }
        this.gender = gender;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getGender() {
        return this.gender;
    }

    public String getType() {
        return this.type;
    }

    public String produceSound(){
        return "Not implemented!";
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.type).append(System.lineSeparator());
        builder.append(String.format("%s %d %s",this.name, this.age, this.gender));
        return builder.toString();
    }
}
