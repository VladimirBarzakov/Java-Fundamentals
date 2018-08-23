import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) {
        String inputPath = System.getProperty("user.dir")+"\\resources\\input.txt";
        String outputPath = System.getProperty("user.dir")+"\\resources\\output.txt";

        try (Scanner scanner = new Scanner(new FileInputStream(inputPath));
             PrintWriter writer = new PrintWriter(outputPath)) {
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    writer.println(scanner.nextInt());
                }
                scanner.next();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
