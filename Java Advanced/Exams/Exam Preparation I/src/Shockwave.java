import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Shockwave {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split("\\s+");
        int rows = Integer.parseInt(tokens[0]);
        int cols = Integer.parseInt(tokens[1]);
        long[][]matrix = new long[rows][];
        for (int i = 0; i < rows; i++) {
            matrix[i]=new long[cols];
        }
        String line;
        while (true){
            line=reader.readLine();
            if ("Here We Go".endsWith(line)){
                break;
            }
            tokens=line.split("\\s+");
            initiateShockwave(matrix,tokens);
        }

        for (int i = 0; i < rows; i++) {
            System.out.println(Arrays.toString(matrix[i]).replaceAll("[\\[\\],]",""));
        }
    }

    private static void initiateShockwave(long[][] matrix, String[] tokens) {
        int x1=Integer.parseInt(tokens[0]);
        int y1=Integer.parseInt(tokens[1]);
        int x2=Integer.parseInt(tokens[2]);
        int y2=Integer.parseInt(tokens[3]);

        for (int r = x1; r <=x2 ; r++) {
            for (int c = y1; c <= y2; c++) {
                matrix[r][c]++;
            }
        }

    }
}
