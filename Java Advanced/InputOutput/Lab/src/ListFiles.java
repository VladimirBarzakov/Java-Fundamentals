import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        String inputPath = System.getProperty("user.dir")+"\\resources\\Files-and-Streams\\";

        File file  = new File(inputPath);

        if (file.exists()){
            if (file.isDirectory()){
                File[] files = file.listFiles();
                for (File f:files){
                    if (!f.isDirectory()){
                        System.out.printf("%s: %s%n",f.getName(), f.length());
                    }
                }
            }
        }
    }
}
