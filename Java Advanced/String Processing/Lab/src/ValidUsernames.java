import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String line;
        List<String> list = new ArrayList<>();
        while (true){
            line=reader.readLine();
            if (line.equals("END")){
                break;
            }
            Pattern pattern = Pattern.compile("^[A-Za-z0-9_-]{3,16}$");
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()){
                list.add("valid");
            } else{
                list.add("invalid");
            }
        }
        if (list.contains("valid")){
            for (String output:list ) {
                System.out.println(output);
            }
        }
    }
}
