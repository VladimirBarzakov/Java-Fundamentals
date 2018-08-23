import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyPicture {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir")+"\\resources\\IMG_20180517_145829.jpg";
        String outputPath = System.getProperty("user.dir")+"\\resources\\output.jpg";

        try (FileInputStream input = new FileInputStream(path);
             FileOutputStream output = new FileOutputStream(outputPath)){
            byte[] buffer = new byte[8192];
            int length;
            while ((length=input.read(buffer))>0){
                    output.write(buffer,0,length);
            }
            output.write(buffer);


        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
