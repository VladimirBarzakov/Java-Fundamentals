import java.io.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CountCharacterTypes {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir")+"\\resources\\input.txt";
        String outputPath = System.getProperty("user.dir")+"\\resources\\output.txt";
        Set<Character> vowels = new HashSet<>();
        Collections.addAll(vowels,'a','e','i','o','u');
        Set<Character> punctuation = new HashSet<>();
        Collections.addAll(punctuation,'!','.',',','?');
        long vowelsCount = 0L;
        long consonantsCount = 0L;
        long punctuationCount = 0L;

        try (BufferedReader reader = new BufferedReader(new FileReader(path));
             PrintWriter writer = new PrintWriter(new FileWriter(outputPath))){
            while (true){
                String line = reader.readLine();
                if (line==null){
                    break;
                }
                for (Character c:line.toCharArray() ) {
                    if ((int)c ==10||(int)c==32 ){
                        continue;
                    } else if (punctuation.contains(c)){
                        punctuationCount++;
                    } else if (vowels.contains(c)){
                        vowelsCount++;
                    } else{
                        consonantsCount++;
                    }
                }
            }
            writer.printf("Vowels: %d%n",vowelsCount);
            writer.printf("Consonants: %d%n",consonantsCount);
            writer.printf("Punctuation: %d%n",punctuationCount);

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
