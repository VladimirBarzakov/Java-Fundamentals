import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class CountSubstringOccurrences {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine().toLowerCase();
        String searchedText = reader.readLine().toLowerCase();

        Set<Integer> orurences = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            int currentOrurence = input.indexOf(searchedText,i);
            if (currentOrurence!=-1){
                orurences.add(currentOrurence);
            }
        }
        System.out.println(orurences.size());
    }
}
