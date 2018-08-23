import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("^\\+359([ -])2\\1[0-9]{3}\\1[0-9]{4}$");
        String line;
        while (true){
            line=reader.readLine();
            if (line.equals("end")){
                break;
            }
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()){
                System.out.println(line);
            }
        }
    }
}
