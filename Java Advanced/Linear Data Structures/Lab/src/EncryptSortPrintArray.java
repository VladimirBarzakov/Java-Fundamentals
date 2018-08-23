import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class EncryptSortPrintArray {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Set<Character> vowels = new HashSet<Character>(Arrays.asList('a','o','u','e','i'));
        String[] arr =new String[n];
        long[] encryptedArr = new long[n];
        for (int i = 0; i<n;i++){
            String input = reader.readLine();
            arr[i]=input;
            long encryptedValue=0;
            for (int j = 0; j < input.length(); j++) {
                if (vowels.contains(Character.toLowerCase(input.charAt(j)) )){
                    encryptedValue+=input.charAt(j)*input.length();
                } else{
                    encryptedValue+=input.charAt(j)/input.length();
                }
            }
            encryptedArr[i]=encryptedValue;
        }
        Arrays.stream(encryptedArr).sorted().forEach(System.out::println);
    }
}
