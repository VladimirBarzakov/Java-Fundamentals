import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LettersChangeNumbers {
    private static boolean isUpperCase(char m)
    {
        boolean isUpperCase = false;
        if ((int)m>=65&&(int)m<=90)
        {
            isUpperCase = true;
        }
        return isUpperCase;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = Arrays.stream(reader.readLine().split("\\s+")).map(String::trim).filter(x->x.length()!=0).toArray(String[]::new);
        double sum = 0;
        for (int i = 0; i < input.length; i++)
        {
            double currSum = 0;
            String token = input[i];
            char firstLetter = token.charAt(0);
            char secondLetter = token.charAt(token.length() - 1);
            double num = Double.parseDouble(token.substring(1,token.length()-1));
            boolean isUpperCase = isUpperCase(firstLetter);
            if (isUpperCase)
            {
                currSum = num / (double)(1 +(int)firstLetter - (int)'A');
            }
            else
            {
                currSum = num * (double)(1 + (int)firstLetter - (int)'a');
            }
            isUpperCase = isUpperCase(secondLetter);
            if (isUpperCase)
            {
                currSum -= (double)(1 +(int)secondLetter - (int)'A');
            }
            else
            {
                currSum += (double)(1 +(int)secondLetter - (int)'a');
            }
            sum += currSum;
        }
        System.out.printf("%.2f",sum);
    }
}
