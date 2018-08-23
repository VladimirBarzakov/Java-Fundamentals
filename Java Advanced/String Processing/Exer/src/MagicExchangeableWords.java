import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class MagicExchangeableWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = Arrays.stream(reader.readLine().split(" "))
                .map(String::toLowerCase).sorted(Comparator.comparingInt(String::length)).toArray(String[]::new);
        HashMap<Character, Character> keyToKey = new HashMap<>();
        for (int i = 0; i < input[0].length(); i++)
        {
            if (input[0].charAt(i) == input[1].charAt(i))
            {
                if (!(keyToKey.containsKey(input[0].charAt(i))) && !(keyToKey.containsKey(input[1].charAt(i))))
                {
                    keyToKey.put(input[0].charAt(i),input[1].charAt(i));
                }
                else if (!(keyToKey.containsKey(input[0].charAt(i))&&
                        keyToKey.get(input[0].charAt(i))== input[1].charAt(i)))
                {
                    System.out.println("false");
                    return;
                }
            }
            else if (!(keyToKey.containsKey(input[0].charAt(i))) && !(keyToKey.containsValue(input[1].charAt(i))))
            {
                keyToKey.put(input[0].charAt(i),input[1].charAt(i));
            }
            else if (!(keyToKey.containsKey(input[0].charAt(i)) &&
                    keyToKey.get(input[0].charAt(i)) == input[1].charAt(i)))
            {
                System.out.println("false");
                return;
            }
        }
        for (int i = input[0].length(); i < input[1].length(); i++)
        {
            if (!keyToKey.containsValue(input[1].charAt(i)))
            {
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");
    }
}
