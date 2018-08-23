import java.io.File;
import java.util.ArrayDeque;
import java.util.Queue;

public class NestedFolders {
    public static void main(String[] args) {
        String inputPath = System.getProperty("user.dir") + "\\resources\\Files-and-Streams\\";

        File file = new File(inputPath);
        int counter = 0;
        Queue<File> queue = new ArrayDeque<>();
        if (file.isDirectory()) {
            queue.add(file);
        }
        counter = getCountAndPrintDirectories(counter, queue);

        System.out.printf("%d folders", counter);


    }

    private static int getCountAndPrintDirectories(int counter, Queue<File> queue) {
        while (!queue.isEmpty()) {
            File file = queue.remove();
            if (!file.isDirectory()) {
                continue;
            }
            System.out.println(file.getName());
            counter++;
            for (File f : file.listFiles()) {
                if (f.isDirectory()) {
                    queue.add(f);
                }
            }

        }
        return counter;
    }
}
