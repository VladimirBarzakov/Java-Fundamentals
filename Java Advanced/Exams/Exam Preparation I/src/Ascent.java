import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ascent {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String,String> decodedWords = new LinkedHashMap<>();
        Pattern pattern = Pattern.compile("(_|,)([A-Za-z]+?)(\\d)");
        String line;
        while (true){
            line=reader.readLine();
            if ("Ascend".equals(line)){
                break;
            }
            line=replaceAllKnown(line,decodedWords);
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()){
                matcher.reset();
                line= untypedLine(line,decodedWords,matcher);
            }
            System.out.println(line);

        }
    }

    private static String untypedLine(String line,
                                      Map<String, String> decodedWords,
                                      Matcher matcher) {
        while (matcher.find()){
            String foundString = matcher.group(0);
            String type = matcher.group(1);
            int typeModifier =0;
            switch (type){
                case ",":
                    typeModifier=+1;
                    break;
                case "_":
                    typeModifier=-1;
                    break;
            }
            String actualMessage = matcher.group(2);
            int modifier = Integer.parseInt(matcher.group(3));
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < actualMessage.length(); i++) {
                builder.append((char)((int)actualMessage.charAt(i)+(typeModifier*modifier)));
            }
            String replacement = builder.toString();
            line=line.replaceAll(foundString,replacement);
            decodedWords.put(foundString,replacement);
        }
        return line;
    }

    private static String replaceAllKnown(String line,Map<String,String> decodedWords) {
        for (String keyWord:decodedWords.keySet() ) {
            line=line.replaceAll(keyWord,decodedWords.get(keyWord));
        }
        return line;
    }
}
