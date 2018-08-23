package p04_froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer[] nums = Arrays.stream(reader.readLine().split("[, ]"))
                .filter(x->!x.equals(" ") && !x.equals(",") && !x.equals(""))
                .map(x->Integer.parseInt(x.trim())).toArray(Integer[]::new);
        Lake<Integer> lake = new Lake<>(nums);
        if ("END".equals(reader.readLine())){
            List<Integer> output = new ArrayList<>();
            lake.forEach(x->output.add(x));
            System.out.println(output.toString().replaceAll("[\\[\\]]",""));
        }
    }
}
