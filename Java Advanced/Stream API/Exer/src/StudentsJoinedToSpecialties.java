import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class StudentsJoinedToSpecialties {

    static class StudentSpecialty{
        private String name;
        private Long facultyNumber;

        public StudentSpecialty(String name, Long facultyNumber) {
            this.name = name;
            this.facultyNumber = facultyNumber;
        }
    }

    static class Student{
        private String name;
        private Long facultyNumber;

        public Student(String name, Long facultyNumber) {
            this.name = name;
            this.facultyNumber = facultyNumber;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<StudentSpecialty> studentSpecialties = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        String line;
        while (true){
            line=reader.readLine();
            if ("Students:".equals(line)){
                break;
            }
            String[] tokens = line.split("\\s+");
            String specialityName = tokens[0].concat(" ").concat(tokens[1]);
            Long facultyNumber = Long.parseLong(tokens[2]);
            StudentSpecialty studentSpecialty = new StudentSpecialty(specialityName,facultyNumber);
            studentSpecialties.add(studentSpecialty);
        }
        while (true){
            line=reader.readLine();
            if ("END".equals(line)){
                break;
            }
            String[] tokens = line.split("\\s+");
            Long facultyNumber = Long.parseLong(tokens[0]);
            String studentName = tokens[1].concat(" ").concat(tokens[2]);
            Student student = new Student(studentName,facultyNumber);
            students.add(student);
        }
        students.stream().sorted(Comparator.comparing(x -> x.name))
                .forEach(x-> studentSpecialties.stream().filter(y->
                        x.facultyNumber.equals(y.facultyNumber))
                                .forEach(y->
                                        System.out.println(
                                        x.name.concat(" ")
                                        .concat(x.facultyNumber.toString())
                                        .concat(" ").concat(y.name))));
    }
}
