import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumLines {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir")+"\\resources\\input.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(path))){
            while (true){
                String line = reader.readLine();
                if (line==null){
                    break;
                }
                long sum = getCharSum(line);
                System.out.println(sum);
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static long getCharSum(String line) {
        long sum=0;
        for (int i = 0; i < line.length(); i++) {
            sum+=(int)line.charAt(i);
        }
        return sum;
    }
}
