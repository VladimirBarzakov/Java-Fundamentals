    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.regex.Matcher;
    import java.util.regex.Pattern;

    public class SentenceExtractor {
        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String searchWord = reader.readLine();
            String line = reader.readLine();
            if (line.isEmpty()||searchWord.isEmpty()){
                return;
            }
            Pattern pattern = Pattern.compile("(?:(?:[\\w-,]+[^\\w\\.|!|\\?]+)+(?:(?:"+searchWord+"[^\\w\\.|!|\\?](?:[^\\.|!|\\?])*)|"+searchWord+"))[\\.|!|\\?]+");
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()){
                System.out.println(matcher.group().trim());
            }

        }
    }
