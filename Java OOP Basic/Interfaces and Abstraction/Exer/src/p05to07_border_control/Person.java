package p05to07_border_control;

import java.util.Set;

public class Person extends Minion implements BorderControlable, Birthable, Buyer {

    private Integer age;
    private String id;
    private String birthDate;
    private int food;

    public Person(String name, Integer age, String id, String birthDate) {
        super(name);
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
        this.food=0;
    }


    public Integer getAge() {
        return this.age;
    }

    public String getId() {
        return this.id;
    }

    @Override
    public boolean isMarkedForCelebrations(String year) {
        return this.birthDate.endsWith(year);
    }

    @Override
    public String getDate() {
        return this.birthDate;
    }

    @Override
    public boolean isIdFake(Set<String> bannedIdPieces) {
        for (String bannedIdPiece:bannedIdPieces) {
            if (this.id.endsWith(bannedIdPiece)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int getFood() {
        return this.food;
    }

    @Override
    public void buyFood() {
        this.food+=10;
    }
}
