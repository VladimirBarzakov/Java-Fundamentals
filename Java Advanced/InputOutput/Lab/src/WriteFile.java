import java.io.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WriteFile {
    public static void main(String[] args) {
        String inputPath = System.getProperty("user.dir")+"\\resources\\input.txt";
        String outputPath = System.getProperty("user.dir")+"\\resources\\output.txt";
        Set<Character> punctuation = new HashSet<>();
        Collections.addAll(punctuation, ',','.','!','?');

        try (InputStream fis = new FileInputStream(inputPath);
             OutputStream fos = new FileOutputStream(outputPath)){
            int oneByte;
            while (true){
                oneByte=fis.read();
                if (oneByte<0){
                    break;
                }
                if (!punctuation.contains((char)oneByte)){
                    fos.write(oneByte);
                }

            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
