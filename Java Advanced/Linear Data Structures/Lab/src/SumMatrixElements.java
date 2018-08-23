import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumMatrixElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split(", ");
        int rows = Integer.parseInt(tokens[0]);
        int cols = Integer.parseInt(tokens[1]);
        long sum =0;

        long[][] matrix = new long[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i]= Arrays.stream(reader.readLine().split(", ")).mapToLong(Long::parseLong).toArray();
            sum+= Arrays.stream(matrix[i]).sum();
        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);

    }
}
