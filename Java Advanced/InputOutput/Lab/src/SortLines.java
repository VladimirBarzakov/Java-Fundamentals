import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) {
        String inputPath = System.getProperty("user.dir")+"\\resources\\input.txt";
        String outputPath = System.getProperty("user.dir")+"\\resources\\output.txt";

        Path in = Paths.get(inputPath);
        Path out = Paths.get(outputPath);

        try {
            List<String> lines = Files.readAllLines(in);
            Collections.sort(lines);
            Files.write(out,lines);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
