package p06_animals;

public class Tomcat extends Cat {
    public Tomcat(String type, String name, int age, String gender) {
        super(type, name, age, gender);
    }

    @Override
    public void setGender(String gender) {
        if (!gender.equals("Male")){
            throw new IllegalArgumentException();
        }
        super.setGender(gender);
    }

    @Override
    public String produceSound() {
        return "Give me one million b***h";
    }
}
