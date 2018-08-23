import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FillTheMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split(", ");
        int n = Integer.parseInt(tokens[0]);
        String type = tokens[1];
        String[][] matrix = fillMatrix(n,type,reader);
        PrintMatrix(matrix);
    }

    private static void PrintMatrix(String[][] matrix) {
        for (String[] row : matrix) {
            for (String element: row) {
                System.out.print(element+" ");
            }
            System.out.println();
        }
    }

    private static String[][] fillMatrix(int n, String type, BufferedReader reader) {
        String[][] matrix = new String[n][n];
        int counter =1;
        if ("A".equals(type)){
            for (int c = 0; c < n; c++) {
                for (int r = 0; r < n; r++) {
                    matrix[r][c]=Integer.toString(counter);
                    counter++;
                }
            }
        } else if ("B".equals(type)){
            for (int c = 0; c < n; c++) {
                for (int r = 0; r < n; r++) {
                    if (c%2==0) {
                        matrix[r][c] = Integer.toString(counter);
                    } else{
                        matrix[n-1-r][c] = Integer.toString(counter);
                    }
                    counter++;
                }
            }
        }
        return matrix;
    }
}
