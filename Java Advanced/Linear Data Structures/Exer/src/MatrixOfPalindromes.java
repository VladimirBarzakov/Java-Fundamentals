import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatrixOfPalindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split(" ");
        int r = Integer.parseInt(tokens[0]);
        int c = Integer.parseInt(tokens[1]);
        int offset = 'a';

        String[][] matrix = new String[r][c];
        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                char edge = (char) (offset+row);
                char middle = (char) (offset+row+col);
                matrix[row][col]= String.valueOf(edge)+
                        String.valueOf(middle)+
                        String.valueOf(edge);
            }
        }
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
}
