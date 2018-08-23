import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class PredicateParty {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> people = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayList::new));
        BiFunction<String, String, Boolean> startsWith = String::startsWith;
        BiFunction<String, String, Boolean> endsWith = String::endsWith;
        BiFunction<String, Integer, Boolean> withLengh = (x,y)-> x.length()==y;
        String line;
        while (true){
            line=reader.readLine();
            if (line.equals("Party!")){
                break;
            }
            String[] tokens = line.split("\\s+");
            String command = tokens[0];
            String parameterType = tokens[1];
            switch (command){
                case "Remove":
                    switch (parameterType){
                        case "StartsWith":
                            for (int i = people.size()-1; i >=0 ; i--) {
                                if (startsWith.apply(people.get(i),tokens[2])){
                                    people.remove(i);
                                }

                            }
                            break;
                        case "EndsWith":
                            for (int i = people.size()-1; i >=0 ; i--) {
                                if (endsWith.apply(people.get(i),tokens[2])){
                                    people.remove(i);
                                }
                            }
                            break;
                        case "Length":
                            for (int i = people.size()-1; i >=0 ; i--) {
                                if (withLengh.apply(people.get(i),Integer.parseInt(tokens[2]))){
                                    people.remove(i);
                                }
                            }
                            break;
                    }
                    break;
                case "Double":
                    switch (parameterType){
                        case "StartsWith":
                            for (int i = 0; i <people.size() ; i++) {
                                if (startsWith.apply(people.get(i),tokens[2])){
                                    people.add(i,people.get(i));
                                    i++;
                                }

                            }
                            break;
                        case "EndsWith":
                            for (int i = 0; i <people.size() ; i++) {
                                if (endsWith.apply(people.get(i),tokens[2])){
                                    people.add(i,people.get(i));
                                    i++;
                                }
                            }
                            break;
                        case "Length":
                            for (int i = 0; i <people.size() ; i++) {
                                if (withLengh.apply(people.get(i),Integer.parseInt(tokens[2]))){
                                    people.add(i,people.get(i));
                                    i++;
                                }
                            }
                            break;
                    }
                    break;
            }
        }

        if (people.size()==0){
            System.out.println("Nobody is going to the party!");
        } else{
            System.out.print(people.toString().replaceAll("[\\[\\]]",""));
            System.out.print(" are going to the party!");
        }
    }
}
