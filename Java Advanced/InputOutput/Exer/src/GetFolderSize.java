import java.io.File;
import java.util.ArrayDeque;
import java.util.Queue;

public class GetFolderSize {
    public static void main(String[] args) {
        String inputPath = System.getProperty("user.dir") + "\\resources\\Exercises Resources\\";

        File file = new File(inputPath);
        long size = 0;
        Queue<File> queue = new ArrayDeque<>();
        if (file.isDirectory()) {
            queue.add(file);
            size = getFolderSize(size, queue);
        } else{
            size=file.length();
        }

        System.out.printf("Folder size: %d", size);

    }

    private static long getFolderSize(long size, Queue<File> queue) {
        while (!queue.isEmpty()){
            File file = queue.poll();
            if (!file.isDirectory()){
                size+=file.length();
            }
            for (File f:file.listFiles()) {
                if (f.isDirectory()){
                    queue.add(f);
                } else{
                    size+=f.length();
                }
            }
        }
        return size;
    }
}
