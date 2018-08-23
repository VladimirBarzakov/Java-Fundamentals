import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StudentsByGroup {

    static class Student{
        String firstName;
        String secondName;

        Student(String firstName, String secondName) {
            this.firstName = firstName;
            this.secondName = secondName;
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
                .filter(x-> x.split("\\s+")[2].equals("2"))
                .map(x->{
                    String[] tokens = x.split("\\s+");
                    return new Student(tokens[0],tokens[1]);
                }).sorted((x,y)->x.firstName.compareTo(y.firstName))
                .forEach(x->System.out.printf("%s %s%n",x.firstName,x.secondName));

    }
}
