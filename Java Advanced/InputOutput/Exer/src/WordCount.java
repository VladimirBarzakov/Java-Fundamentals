import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.stream.Collectors;

public class WordCount {
    public static void main(String[] args) {
        String wordsPath = System.getProperty("user.dir") + "\\resources\\words.txt";
        String textPath = System.getProperty("user.dir") + "\\resources\\text.txt";
        String outputPath = System.getProperty("user.dir") + "\\resources\\results.txt";
        Map<String, Long> wordsCount = new HashMap<>();

        try (BufferedReader searchWordsReader = new BufferedReader(new FileReader(wordsPath));
             BufferedReader textReader = new BufferedReader(new FileReader(textPath));
             PrintWriter writer = new PrintWriter(new FileWriter(outputPath))) {
            getSearchedWords(searchWordsReader,wordsCount);
            matchSearchedWords(textReader, wordsCount);

            for (String key:wordsCount.keySet().stream()
                    .sorted((x,y)->wordsCount.get(y).compareTo(wordsCount.get(x)))
                    .collect(Collectors.toCollection(LinkedHashSet::new))
                 ) {
                writer.printf("%s - %d%n",key,wordsCount.get(key));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void matchSearchedWords(BufferedReader textReader, Map<String,Long> wordsCount) throws IOException {
        while (true) {
            String line = textReader.readLine();
            if (line == null) {
                break;
            }
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                if (wordsCount.containsKey(token)) {
                    wordsCount.put(token, wordsCount.get(token) + 1);
                }
            }
        }
    }

    private static void getSearchedWords(BufferedReader searchWordsReader, Map<String, Long> wordsCount) throws IOException {
        while (true) {
            String line = searchWordsReader.readLine();
            if (line == null) {
                break;
            }
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                if (!wordsCount.containsKey(token)) {
                    wordsCount.put(token, 0L);
                }
            }
        }
    }
}
