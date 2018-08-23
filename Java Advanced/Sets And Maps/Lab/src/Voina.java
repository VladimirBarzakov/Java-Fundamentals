import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class Voina {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashSet<Integer> playerA = getPlayerNumbers(reader);
        LinkedHashSet<Integer> playerB = getPlayerNumbers(reader);

        for (int i = 0; i < 50; i++) {
            if (playerA.isEmpty() || playerB.isEmpty()){
               break;
            }

            int firstNumber = playerA.iterator().next();
            playerA.remove(firstNumber);
            int secondNumber = playerB.iterator().next();
            playerB.remove(secondNumber);

            if (firstNumber>secondNumber){
                playerA.add(firstNumber);
                playerA.add(secondNumber);
            } else if(firstNumber<secondNumber){
                playerB.add(firstNumber);
                playerB.add(secondNumber);
            } else{
                playerA.add(firstNumber);
                playerB.add(secondNumber);
            }
        }
        if (playerA.size()>playerB.size()){
            System.out.println("First player win!");
        } else if (playerA.size()<playerB.size()){
            System.out.println("Second player win!");
        } else{
            System.out.println("Draw!");
        }

    }

    private static LinkedHashSet<Integer> getPlayerNumbers(BufferedReader reader) throws IOException {
        int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        LinkedHashSet<Integer> hashSet = new LinkedHashSet<>();
        for (int anArray : array) {
            hashSet.add(anArray);
        }
        return hashSet;
    }
}
