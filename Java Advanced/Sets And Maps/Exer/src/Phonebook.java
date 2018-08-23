import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Phonebook {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> phoneBook = new HashMap<>();
        String line;
        while (!"search".equals(line=reader.readLine())){
            String[] tokens = line.split("-");
            String name = tokens[0];
            String number = tokens[1];
            phoneBook.put(name,number);
        }
        while (!"stop".equals(line=reader.readLine())){

            if (phoneBook.containsKey(line)){
                System.out.printf("%s -> %s%n",line,phoneBook.get(line));
            } else{
                System.out.printf("Contact %s does not exist.%n",line);
            }
        }


    }
}
