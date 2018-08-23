import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Palindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("[\\s,.?!]");
        TreeSet<String> palindromes = new TreeSet<>();
        for (String word:input) {
            if (word.length()!=0&&isPalindrome(word)){
                palindromes.add(word);
            }
        }
        System.out.println(palindromes.toString());
    }

    private static boolean isPalindrome(String word) {
        boolean isPalidrome = true;
        for (int i = 0; i < word.length()/2; i++) {
            if (word.charAt(i)!=word.charAt(word.length()-1-i)){
                isPalidrome=false;
                break;
            }
        }
        return isPalidrome;
    }
}
