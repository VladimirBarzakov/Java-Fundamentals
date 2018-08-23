import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StudentsByAge {

    static class Student{
        String firstName;
        String secondName;
        int age;

        Student(String firstName, String secondName, int age) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.age=age;
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
                    return new Student(tokens[0],tokens[1],Integer.parseInt(tokens[2]));
                }).filter(x->x.age>=18 && x.age<=24)
                .forEach(x->System.out.printf("%s %s %d%n",x.firstName,x.secondName,x.age));

    }
}
