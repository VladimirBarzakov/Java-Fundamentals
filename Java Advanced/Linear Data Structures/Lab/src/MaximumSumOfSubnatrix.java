import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaximumSumOfSubnatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split(", ");
        int rows = Integer.parseInt(tokens[0]);
        int cols = Integer.parseInt(tokens[1]);
        long maxSum =Long.MIN_VALUE;
        Long[][] subMatrix = new Long[2][2];

        long[][] matrix = new long[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i]= Arrays.stream(reader.readLine().split(", ")).mapToLong(Long::parseLong).toArray();
        }

        for (int r = 0; r < rows-1; r++) {
            for (int c = 0; c < cols-1; c++) {
                long currentSum= getCurrentSum(matrix,r,c,2);
                if (currentSum>maxSum){
                    maxSum=currentSum;
                    subMatrix=getSubmatrix(matrix, subMatrix, r,c);
                }
            }
        }
        for (int i = 0; i < subMatrix.length; i++) {
            for (int j = 0; j < subMatrix[i].length; j++) {
                System.out.print(subMatrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(maxSum);
    }

    private static Long[][] getSubmatrix(long[][] matrix, Long[][] subMatrix, int r, int c) {
        for (int i = r; i < r+subMatrix.length; i++) {
            for (int j = c; j < c+subMatrix[i-r].length; j++) {
                subMatrix[i-r][j-c]=matrix[i][j];
            }
        }
        return subMatrix;
    }

    private static long getCurrentSum(long[][] matrix, int r, int c, int sizeOfSubmatrix) {
        long res =0;
        for (int i = r; i < r+sizeOfSubmatrix; i++) {
            for (int j = c; j < c+sizeOfSubmatrix; j++) {
                res+=matrix[i][j];
            }
        }
        return res;
    }
}
