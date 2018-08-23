import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) {
        String inputPath = System.getProperty("user.dir")+"\\resources\\input.txt";
        String outputPath = System.getProperty("user.dir")+"\\resources\\output.txt";


        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             PrintWriter writer = new PrintWriter(new FileWriter(outputPath))){
            int counter = 1;

            String line = reader.readLine();
            while (line!=null){
                if (counter%3==0){
                    writer.println(line);
                }
                counter++;
                line=reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
