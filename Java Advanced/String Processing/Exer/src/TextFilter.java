    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;

    public class TextFilter {
        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String[] bannedWords = reader.readLine().split(", ");
            String input = reader.readLine();

            for (String bannedWord:bannedWords) {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < bannedWord.length(); i++) {
                    builder.append("*");
                }
                String replaceWord = builder.toString();
                while (input.contains(bannedWord)){
                    input = input.replaceFirst(bannedWord,replaceWord);
                }
            }

            System.out.println(input);




        }
    }
