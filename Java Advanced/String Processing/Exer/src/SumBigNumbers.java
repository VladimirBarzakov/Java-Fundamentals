import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumBigNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String num1 = trimZeroes(reader.readLine());
        String num2 = trimZeroes(reader.readLine());


        StringBuilder builder = new StringBuilder();
        int remaider = 0;

        for (int i = 0; i < Math.max(num1.length(),num2.length()); i++) {
            int a =0;
            if (i<num1.length()){
                a=Integer.parseInt(String.valueOf(num1.charAt(num1.length()-1-i)));
            }
            int b =0;
            if (i<num2.length()){
                b=Integer.parseInt(String.valueOf(num2.charAt(num2.length()-1-i)));
            }
            int sum = a+b+remaider;
            builder.append(sum%10);
            remaider=sum/10;
        }
        if (remaider!=0){
            builder.append(remaider);
        }
        System.out.println(builder.reverse().toString());
    }

    private static String trimZeroes(String s) {
        while (s.startsWith("0")){
            s=s.substring(1);
        }
        return s;
    }
}
