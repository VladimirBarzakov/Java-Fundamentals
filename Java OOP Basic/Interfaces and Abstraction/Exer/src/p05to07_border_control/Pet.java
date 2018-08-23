package p05to07_border_control;

public class Pet extends Minion implements Birthable{

    private String birthDate;

    public Pet(String name, String birthDate) {
        super(name);
        this.birthDate=birthDate;
    }


    @Override
    public boolean isMarkedForCelebrations(String year) {
        return this.birthDate.endsWith(year);
    }

    @Override
    public String getDate() {
        return this.birthDate;
    }
}
