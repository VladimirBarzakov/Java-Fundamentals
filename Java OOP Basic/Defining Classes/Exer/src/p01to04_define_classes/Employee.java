package p01to04_define_classes;

public class Employee {



    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private Integer age;

    public Employee() {
    }

    public Employee(String name, double salary, String position, String department) {
        this(name,salary,position,department,null,null);
    }

    public Employee(String name, double salary, String position, String department, String email, Integer age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString(){
        int printAge;
        if (this.age==null){
            printAge=-1;
        } else{
            printAge=this.age;
        }
        String printEmail;
        if (this.email==null){
            printEmail="n/a";
        } else{
            printEmail=this.email;
        }
        return String.format("%s %.2f %s %d",this.name,this.salary,printEmail,printAge);
    }
}
