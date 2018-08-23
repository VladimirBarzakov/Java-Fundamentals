import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FilterStudentsByPhone {

    static class Student{
        String firstName;
        String secondName;
        String phone;

        Student(String firstName, String secondName, String phone) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.phone =phone;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> input = new ArrayList<>();
        String line;
        while (true){
            line=reader.readLine();
            if ("END".equals(line)){
                break;
            }
            input.add(line);
        }

        input.stream()
                .map(x->{
                    String[] tokens = x.split("\\s+");
                    return new Student(tokens[0],tokens[1],tokens[2]);
                }).filter(x->x.phone.startsWith("02") || x.phone.startsWith("+3592"))
                .forEach(x->System.out.printf("%s %s%n",x.firstName,x.secondName));

    }
}
