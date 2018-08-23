import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumSum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split(" ");
        int row = Integer.parseInt(tokens[0]);
        int col = Integer.parseInt(tokens[1]);
        long[][] matrix = new long[row][col];
        fillMatrix(reader,matrix);
        int bestRow=0;
        int bestCol=0;
        long bestSum=Long.MIN_VALUE;
        for (int r = 0; r < matrix.length - 2; r++) {
            for (int c = 0; c < matrix[r].length-2; c++) {
                long currentSum=getSubMatrixSum(matrix,r,c);
                if (bestSum<currentSum){
                    bestSum=currentSum;
                    bestRow=r;
                    bestCol=c;

                }

            }
        }
        System.out.println("Sum = "+bestSum);
        for (int r = bestRow; r < bestRow+3; r++) {
            for (int c = bestCol; c < bestCol+3; c++) {
                System.out.print(matrix[r][c]+" ");
            }
            System.out.println();
        }
    }

    private static long getSubMatrixSum(long[][] matrix, int r, int c) {
        long result =0;
        for (int row = r; row < r+3; row++) {
            for (int col = c; col < c+3; col++) {
                result+=matrix[row][col];
            }
        }
        return result;
    }

    private static void fillMatrix(BufferedReader reader, long[][] matrix) throws IOException {
        for (int r = 0; r < matrix.length; r++) {
            String[] tokens = reader.readLine().split(" ");
            for (int c = 0; c < matrix[r].length; c++) {
                matrix[r][c] = Long.parseLong(tokens[c]);
            }
        }

    }
}
