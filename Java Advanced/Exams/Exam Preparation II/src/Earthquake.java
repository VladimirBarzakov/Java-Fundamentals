import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Earthquake {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        ArrayDeque<ArrayDeque<Integer>> seismicActivity = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            ArrayDeque<Integer> seismicWave = Arrays.stream(reader.readLine().split(" "))
                    .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
            seismicActivity.addLast(seismicWave);
        }
        long counter = 0;
        ArrayDeque<Integer> result = new ArrayDeque<>();
        while (!seismicActivity.isEmpty()){
            ArrayDeque<Integer> wave = seismicActivity.removeFirst();
            Integer currentSeismic = wave.removeFirst();
            while (!wave.isEmpty() && currentSeismic>=wave.getFirst()){
                wave.removeFirst();
            }
            counter++;
            result.addLast(currentSeismic);
            if (!wave.isEmpty()){
                seismicActivity.addLast(wave);
            }
        }

        System.out.println(counter);
        result.forEach(x-> System.out.printf("%d ",x));
    }
}
