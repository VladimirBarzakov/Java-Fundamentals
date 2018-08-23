import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class UnicodeCharacters {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> builder = new ArrayList<>();
        String input = reader.readLine();
        for (int i = input.length()-1; i >=0 ; i--) {
            builder.add("\\u"+String.format("%1$4s",Integer.toHexString((int)input.charAt(i))).replace(" ","0") );
        }
        for (int i = builder.size()-1; i >=0 ; i--) {
            System.out.print(builder.get(i));
        }
    }
}
