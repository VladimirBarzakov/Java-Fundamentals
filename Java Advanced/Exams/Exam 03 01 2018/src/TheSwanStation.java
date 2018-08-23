import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TheSwanStation {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] ints = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        ArrayDeque<BigInteger> theNumbers = new ArrayDeque<>();
        for (int anInt : ints) {
            theNumbers.addLast(new BigInteger(String.valueOf(anInt)));
        }
        ints = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        ArrayDeque<BigInteger> nums = new ArrayDeque<>();
        for (int anInt : ints) {
            nums.addLast(new BigInteger(String.valueOf(anInt)));
        }

        List<BigInteger> result =new ArrayList<>();

        while (result.size()<6){
            if (nums.getFirst().mod(theNumbers.getFirst()).equals(BigInteger.ZERO)){
                result.add(nums.removeFirst());
                theNumbers.removeFirst();
            } else{
                nums.addLast(nums.removeFirst().add(BigInteger.ONE));
            }
        }
        System.out.println(result.toString().replaceAll("[\\[\\]]",""));
    }
}
