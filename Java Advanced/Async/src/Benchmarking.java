import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Benchmarking {

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i <=n ; i++) {
            numbers.add(i);
        }
        long start = System.nanoTime();
        ExecutorService es = Executors.newFixedThreadPool(4);
        Future[] results = new Future[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            Integer integer = numbers.get(i);
            Future<Boolean> future = es.submit(()->isPrime(integer));
            results[i]=future;
        }
        es.awaitTermination(100L,TimeUnit.MILLISECONDS);
        long total = System.nanoTime()-start;
        System.out.println("Execution time "+total);
        es.shutdown();
        ///for (Future f:results ) {
        ///    System.out.println(f.get());
        ///}

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
