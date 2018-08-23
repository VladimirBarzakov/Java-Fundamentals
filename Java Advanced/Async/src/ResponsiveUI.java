import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ResponsiveUI {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("n =");
        int n = Integer.parseInt(reader.readLine());

        Runnable taks = ()->printPrimes(n);

        Thread thread = new Thread(taks);
        thread.start();
        //thread.join();
        while (true){
            String command = reader.readLine();
            if (command.equals("stop")){
                thread.interrupt();
                break;
            } else{
                System.out.println("unknown command");
            }
        }
        thread.join();

    }

    static  void printPrimes(int to){
        List<Integer> primes = new ArrayList<>();
        for (int number = 0; number < to; number++) {
            if (isPrime(number)){
                primes.add(number);
            }

            if (Thread.currentThread().isInterrupted()){
                System.out.println("Interrupted....");
                break;
            }
        }

        System.out.println(primes.toString());
        System.out.printf("%s primes calculated.",primes.size());
    }

    private static boolean isPrime(int number) {
        if (number<2){
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number%i==0){
                return false;
            }
        }

        return true;
    }
}
