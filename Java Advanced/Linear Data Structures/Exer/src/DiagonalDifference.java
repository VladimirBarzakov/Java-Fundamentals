import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DiagonalDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        long[][] matrix = new long[n][n];
        fillMatrix(reader,matrix);
        long sumDiagOne =0;
        for (int i = 0; i < n; i++) {
            sumDiagOne+=matrix[i][i];
        }
        long sumDiagTwo =0;
        for (int i = 0; i < n; i++) {
            sumDiagTwo+=matrix[i][n-1-i];
        }
        System.out.println(Math.abs(sumDiagOne-sumDiagTwo));
        
    }

    private static void fillMatrix(BufferedReader reader, long[][] matrix) throws IOException {
        for (int r = 0; r < matrix.length; r++) {
            String[] tokens = reader.readLine().split(" ");
            for (int c = 0; c < matrix.length; c++) {
                matrix[r][c] = Long.parseLong(tokens[c]);
            }
        }
    }
}
