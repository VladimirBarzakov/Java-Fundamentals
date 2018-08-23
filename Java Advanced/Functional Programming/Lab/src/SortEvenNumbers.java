import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SortEvenNumbers {

    private static BufferedReader br;

    static {
        br=new BufferedReader(new InputStreamReader(System.in));
    }


    public static void main(String[] args) throws IOException {
        ArrayList<Integer> nums = Arrays.stream(br.readLine().split(", "))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toCollection(ArrayList::new));

        nums.removeIf(x->x%2!=0);
        System.out.println(nums.toString().replaceAll("[\\[\\]]",""));

        nums.sort((a,b)->a.compareTo(b));
        System.out.println(nums.toString().replaceAll("[\\[\\]]",""));
    }
}
