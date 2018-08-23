import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        String line;
        while (true){
            line=reader.readLine();
            if ("end".equals(line)){
                break;
            }
            builder.append(line);
        }
        line = builder.toString();
        String userPattern="(?:^|\\s)([A-Za-z0-9][A-Za-z0-9_.-]*[A-Za-z0-9]";
        String hostPattern = "[A-Za-z-]+\\.[A-Za-z-]+(?:\\.([A-Za-z-])+)*)(?:\\.|,|\\s|$)";
        String emailPattern = userPattern+"@"+hostPattern;
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()){
            System.out.println(matcher.group(1));
        }


    }
}
