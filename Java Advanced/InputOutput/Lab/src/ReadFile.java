import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir")+"\\resources\\input.txt";
        try (FileInputStream fs = new FileInputStream(path)){
            int oneByte = fs.read();
            while (oneByte>=0){
                System.out.printf("%s ",Integer.toBinaryString(oneByte));
                oneByte=fs.read();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
