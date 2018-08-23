import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class MathPotato {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] children = reader.readLine().split("\\s+");
        int n = Integer.parseInt(reader.readLine());

        ArrayDeque<String> queue = new ArrayDeque<>();
        int counter=1;
        for (String child:children){
            queue.offer(child);
        }
        while (queue.size()>1){

            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }

            if (!isPrimeNumber(counter)){
                System.out.println("Removed "+queue.poll());
            } else{
                System.out.println("Prime "+queue.peek());
            }
            counter++;
        }
        System.out.println("Last is " + queue.poll());
    }

    private static boolean isPrimeNumber(int counter) {
        if (counter==1){
            return false;
        } else if (counter==2){
            return true;
        }  else{
            int border = (int)Math.sqrt(counter);
            for (int i = 2; i <=border ; i++) {
                if (counter%i==0){
                    return false;
                }
            }
            return true;
        }
    }
}
