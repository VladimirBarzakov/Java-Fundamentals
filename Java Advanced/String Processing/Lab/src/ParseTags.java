import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParseTags {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        while (true){
            int startIndex = input.indexOf("<upcase>");
            int endIndex = input.indexOf("</upcase>");
            if (startIndex==-1||endIndex==-1){
                break;
            }
            String target = input.substring(startIndex,endIndex+9);
            String replace = target.substring(8,target.length()-9).toUpperCase();
            input = input.replaceFirst(target,replace);

        }
        System.out.println(input);
    }
}
