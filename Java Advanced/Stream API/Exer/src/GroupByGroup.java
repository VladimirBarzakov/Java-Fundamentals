import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByGroup {
    static class Student{
        String name;
        int group;

        Student(String name, int group) {
            this.name = name;
            this.group = group;
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

        Map<Integer, List<Student>> studentMap = input.stream()
                .map(x -> {
                    String[] tokens = x.split("\\s+");
                    return new Student(tokens[0]+" "+tokens[1], Integer.parseInt(tokens[2]));
                }).collect(Collectors.groupingBy(x -> x.group));

        studentMap.forEach((key, value) -> {
            System.out.printf("%d - ", key);
            System.out.printf("%s%n", Arrays.toString(value.stream().map(x -> x.name).toArray()).replaceAll("[\\[\\]]", ""));
        });

    }
}

