package p10_family_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line= reader.readLine();
        String personKey =line;
        if (isDate(line)){
            Person person = new Person();
            person.setBirthDate(line);
        } else{
            Person person = new Person();
            person.setName(line);
        }

        while (true){
            line=reader.readLine();
            if ("End".equals(line)){
                break;
            }
            String[] tokens;
            if (line.contains("-")){
                tokens = line.split(" - ");
                Person parent=getPerson(tokens[0]);
                Person child=getPerson(tokens[1]);

                parent.getChildren().add(child);
                child.getParents().add(parent);
            } else{
                tokens = new String[2];
                StringBuilder builder = new StringBuilder();
                Arrays.stream(line.split("\\s+")).limit(2)
                        .forEach(x->builder.append(x).append(" "));
                tokens[0]=builder.toString().trim();
                builder.setLength(0);
                Arrays.stream(line.split("\\s+")).skip(2)
                        .forEach(x->builder.append(x).append(" "));
                tokens[1]=builder.toString().trim();
                Person.connectNameWithBirthDate(tokens[0],tokens[1]);
            }

        }
        if (isDate(personKey)){
            System.out.println(Person.getByBirthDate(personKey));
        } else{
            System.out.println(Person.getByName(personKey));
        }
    }

    private static Person getPerson(String token) {
        Person parent;
        if (isDate(token)){
            parent = Person.getByBirthDate(token);
            if (parent==null){
                parent = new Person();
                parent.setBirthDate(token);
            }
        } else{
            parent=Person.getByName(token);
            if (parent==null){
                parent = new Person();
                parent.setName(token);
            }
        }
        return parent;
    }

    private static boolean isDate(String line) {
        String pattern = "\\d+/\\d+/\\d+";
        return line.matches(pattern);
    }
}
