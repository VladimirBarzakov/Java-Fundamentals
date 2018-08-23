
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class PoisonousPlants {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] plants = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> indexes = new ArrayDeque<>();
        indexes.push(0);

        int[] days = new int[n];

        for (int i = 1 ; i < n; i++)
        {
            int maxDays = 0;
            while (indexes.size() > 0 && plants[indexes.peek()] >= plants[i])
            {
                maxDays = Math.max(maxDays, days[indexes.pop()]);
            }

            if (indexes.size() > 0)
            {
                days[i] = maxDays + 1;
            }

            indexes.push(i);
        }


        int nDays =Integer.MIN_VALUE;
        for (int i = 0; i < days.length; i++) {
            if (days[i]>nDays){
                nDays=days[i];
            }
        }
        System.out.println(nDays);
    }
}


