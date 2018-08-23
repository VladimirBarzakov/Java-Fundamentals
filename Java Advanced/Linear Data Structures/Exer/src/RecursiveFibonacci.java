import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        HashMap<Long, BigInteger> calculatedValues = new HashMap<>();
        Long n = Long.parseLong(sc.nextLine());
        BigInteger value = recursiveFibonachi(calculatedValues,n+1);
        System.out.println(value);
    }

    private static BigInteger recursiveFibonachi(HashMap<Long,BigInteger> calculatedValues, long n) {
        if (n==1){
            return BigInteger.ONE;
        } else if (n<=0){
            return BigInteger.ZERO;
        }
        BigInteger a;
        if (calculatedValues.containsKey(n-1)){
            a = calculatedValues.get(n-1);
        } else{
            a = recursiveFibonachi(calculatedValues,n-1);
            calculatedValues.put(n-1,a);
        }
        BigInteger b;
        if (calculatedValues.containsKey(n-2)){
            b = calculatedValues.get(n-2);
        } else{
            b = recursiveFibonachi(calculatedValues,n-2);
            calculatedValues.put(n-2,b);
        }
        return a.add(b);
    }
}
