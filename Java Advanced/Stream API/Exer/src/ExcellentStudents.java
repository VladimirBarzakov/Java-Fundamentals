import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExcellentStudents {

    static class Student{
        String firstName;
        String secondName;
        List<String> marks;

        Student(String firstName, String secondName, List<String> marks) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.marks=marks;
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
                    List<String> marks = Arrays.stream(tokens).skip(2).collect(Collectors.toList());
                    return new Student(tokens[0],tokens[1],marks);
                }).filter(x->x.marks.stream().anyMatch(y->y.equals("6")))
                .forEach(x->System.out.printf("%s %s%n",x.firstName,x.secondName));

    }
}
