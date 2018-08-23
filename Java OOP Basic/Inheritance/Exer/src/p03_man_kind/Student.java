package p03_man_kind;

public class Student extends Human {
    private String facultyNumber;

    public Student(String firstName, String lastName, String facultyNumber) {
        super(firstName, lastName);
        this.setFacultyNumber(facultyNumber);
    }

    public void setFacultyNumber(String facultyNumber) {
        if (facultyNumber.length()<5 || facultyNumber.length()>10){
            throw new IllegalArgumentException("Invalid faculty number!");
        }
        this.facultyNumber = facultyNumber;
    }

    @Override
    public String toString() {
        return super.toString()
                +System.lineSeparator()
                +String.format("Faculty number: %s%n",this.facultyNumber);
    }
}
