import java.io.*;

public class LineNumbers {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir")+"\\resources\\inputLineNumbers.txt";
        String outputPath = System.getProperty("user.dir")+"\\resources\\output.txt";
        long lineCount =0;

        try (BufferedReader reader = new BufferedReader(new FileReader(path));
             PrintWriter writer = new PrintWriter(new FileWriter(outputPath))){
            while (true){
                String line = reader.readLine();
                if (line==null){
                    break;
                }
                lineCount++;
                writer.println(lineCount+". "+line);

            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
