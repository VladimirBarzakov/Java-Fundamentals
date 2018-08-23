import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.function.Consumer;

public class AppliedArithmetic {
    private static BufferedReader br;

    static {
        br=new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        BigInteger[] nums = Arrays.stream(br.readLine().split("\\s+"))
                .map(BigInteger::new).toArray(BigInteger[]::new);

        String line;
        Consumer<BigInteger[]> print = x ->{
            for (BigInteger aX : x) {
                System.out.print(String.format("%s ", aX));
            }
            System.out.println();
        };
        Consumer<BigInteger[]> add = x ->{
            for (int i = 0; i < x.length; i++) {
                x[i]=x[i].add(BigInteger.ONE);
            }
        };
        Consumer<BigInteger[]> subtract = x ->{
            for (int i = 0; i < x.length; i++) {
                x[i]=x[i].subtract(BigInteger.ONE);
            }
        };
        Consumer<BigInteger[]> multiply = x ->{
            for (int i = 0; i < x.length; i++) {
                x[i]=x[i].multiply(new BigInteger("2"));
            }
        };

        while (true){
            line=br.readLine();
            if ("end".equals(line)){
                //print.accept(nums);
                break;
            }
            switch (line){
                case "add":
                    add.accept(nums);
                    break;
                case "multiply":
                    multiply.accept(nums);
                    break;
                case "subtract":
                    subtract.accept(nums);
                    break;
                case "print":
                    print.accept(nums);
                    break;
            }
        }

    }
}
