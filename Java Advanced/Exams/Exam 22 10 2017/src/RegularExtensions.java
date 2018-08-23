import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExtensions {

    private static BufferedReader reader;
    private static StringBuilder builder;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        builder = new StringBuilder();

    }

    public static void main(String[] args) throws IOException {

        String text = reader.readLine();
        String line;
        String extender = "[^\\s]*";

        while (true){
            line=reader.readLine();
            if ("Print".equals(line)){
                break;
            }
            String[] tokens = line.split("%");
            boolean startsWith = line.startsWith("%");
            boolean endsWith = line.endsWith("%");
            boolean singleChar = false;
            String patternStr;
            if (line.equals("%")){
                patternStr=extender;
                singleChar=true;
            }
            else if (tokens.length==1){
                patternStr=Pattern.quote(tokens[0]);
            } else{
                for (int i = 0; i < tokens.length; i++) {
                    if (i==tokens.length-1){
                        builder.append(Pattern.quote(tokens[i]));
                    } else{
                        builder.append(Pattern.quote(tokens[i])).append(extender);
                    }
                }
                patternStr=builder.toString();
                builder.setLength(0);
            }
            if (!singleChar){
                if (startsWith){
                    patternStr=extender+patternStr;
                }
                if (endsWith){
                    patternStr=patternStr+extender;
                }
            }
            Pattern pattern = Pattern.compile(patternStr);
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()){
                text= text.replaceFirst(matcher.group(),builder.append(matcher.group()).reverse().toString());
                builder.setLength(0);
            }
        }
        System.out.println(text);
    }



}
