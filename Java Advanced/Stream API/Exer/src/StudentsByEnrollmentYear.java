import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StudentsByEnrollmentYear {
    static class Student{
        String fackNumber;
        List<Integer> marks;

        Student(String fackNumber, List<Integer> marks) {
            this.fackNumber = fackNumber;
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
                    List<Integer> marks = Arrays.stream(tokens).skip(1)
                            .mapToInt(Integer::parseInt)
                            .boxed()
                            .collect(Collectors.toList());
                    return new Student(tokens[0],marks);
                }).filter(x->x.fackNumber.endsWith("14") || x.fackNumber.endsWith("15") )
                .forEach(x->System.out.printf("%s%n",x.marks.toString().replaceAll("[\\[\\],]","")));

    }

}
