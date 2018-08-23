import java.io.*;

public class AllCapitals {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir")+"\\resources\\input.txt";
        String outputPath = System.getProperty("user.dir")+"\\resources\\output.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(path));
             PrintWriter writer = new PrintWriter(new FileWriter(outputPath))){
            while (true){
                String line = reader.readLine();
                if (line==null){
                    break;
                }
                line = line.toUpperCase();
                writer.println(line);
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
