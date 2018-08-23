import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BoundedNumbers {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Long> bounds = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Long::parseLong).collect(Collectors.toList());

        List<Long> nums = Arrays.stream(reader.readLine().split("\\s+")).mapToLong(Long::parseLong)
                .filter(x->x>= Collections.min(bounds) && x<=Collections.max(bounds)).boxed()
                .collect(Collectors.toList());

        for (Long num:nums ) {
            System.out.printf("%d ",num);
        }
    }
}
