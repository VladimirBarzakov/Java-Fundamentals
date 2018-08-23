import java.io.*;

public class CopyBytes {
    public static void main(String[] args) {
        String inputPath = System.getProperty("user.dir")+"\\resources\\input.txt";
        String outputPath = System.getProperty("user.dir")+"\\resources\\output.txt";

        try (InputStream fis = new FileInputStream(inputPath);
             OutputStream fos = new FileOutputStream(outputPath)){
            int oneByte;
            while (true){
                oneByte=fis.read();
                if (oneByte<0){
                    break;
                }
                if (oneByte==10 || oneByte==32){
                    fos.write(oneByte);
                } else {
                    String digit = String.valueOf(oneByte);
                    for (int i = 0; i < digit.length(); i++) {
                        fos.write(digit.charAt(i));
                    }
                }

            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
