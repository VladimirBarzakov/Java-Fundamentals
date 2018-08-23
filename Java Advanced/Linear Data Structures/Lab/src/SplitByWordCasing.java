import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SplitByWordCasing {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split("[.!,/()'`\\\\\";:\\[\\]\\s]");
        List<String> lowerCase = new ArrayList<>();
        List<String> upperCase = new ArrayList<>();
        List<String> mixedCase = new ArrayList<>();
        for (String  string:  tokens) {
            if (string.trim().length()==0){
                continue;
            }
            boolean isUpperCase = true;
            boolean isLowerCase = true;
            for (int i = 0; i < string.length(); i++) {
                if (!Character.isLetter(string.charAt(i))){
                    isLowerCase=false;
                    isUpperCase=false;
                    break;
                } else if(Character.isUpperCase(string.charAt(i))){
                    isLowerCase=false;
                } else {
                    isUpperCase=false;
                }
            }
            if ( !isLowerCase && !isUpperCase){
                mixedCase.add(string);
            } else if(isLowerCase){
                lowerCase.add(string);
            } else {
                upperCase.add(string);
            }
        }
        System.out.printf("Lower-case: %s%n",String.join(", ",lowerCase));
        System.out.printf("Mixed-case: %s%n",String.join(", ",mixedCase));
        System.out.printf("Upper-case: %s%n",String.join(", ",upperCase));

    }
}
