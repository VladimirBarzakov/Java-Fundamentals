import java.io.*;

public class MergeTwoFiles {
    public static void main(String[] args) {
        String path1 = System.getProperty("user.dir")+"\\resources\\inputOne.txt";
        String path2 = System.getProperty("user.dir")+"\\resources\\inputTwo.txt";
        String outputPath = System.getProperty("user.dir")+"\\resources\\output.txt";
        try (BufferedReader readerPh1 = new BufferedReader(new FileReader(path1));
             BufferedReader readerPh2 = new BufferedReader(new FileReader(path2));
             PrintWriter writer = new PrintWriter(new FileWriter(outputPath))){
            while (true){
                String line = readerPh1.readLine();
                if (line==null){
                    break;
                }
                writer.println(line);
            }
            while (true){
                String line = readerPh2.readLine();
                if (line==null){
                    break;
                }
                writer.println(line);
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
