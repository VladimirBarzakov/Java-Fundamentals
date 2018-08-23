import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.UnaryOperator;

public class AddVAT {

    private static BufferedReader br;
    static {
        br=new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {

        double[] nums = Arrays.stream(br.readLine().split(", "))
                .mapToDouble(Double::parseDouble).toArray();

        UnaryOperator<Double> addVat = x->x*1.2d;
        System.out.println("Prices with VAT:");
        for (int i = 0; i < nums.length; i++) {
            nums[i]=addVat.apply(nums[i]);
            System.out.printf("%.2f%n",nums[i]);
        }
    }
}
