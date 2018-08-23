import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceTag {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("<a (?:\\r\\n)*href=((?!<a>)(?:.|\\r\\n).*?>(?:.|\\r\\n)*?)</a>");
        StringBuilder builder = new StringBuilder();
        String line;
        while (true){
            line=reader.readLine();
            if ("END".equals(line)){
                break;
            }
            builder.append(line).append(System.lineSeparator());
        }
        String result = builder.toString();
        Matcher matcher=pattern.matcher(result);
        while (matcher.find()){
            String toFind = matcher.group();
            String link = matcher.group(1).replace('>',']');
            String replace = "[URL href=".concat(link).concat("[/URL]");
            result=result.replaceFirst(toFind,replace);
            String debug="";
        }
        System.out.println(result);
    }
}
