import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatrixShuffling {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split(" ");
        int rows = Integer.parseInt(tokens[0]);
        int cols = Integer.parseInt(tokens[1]);
        String[][] matrix = new String[rows][cols];
        fillMatrix(reader, matrix);
        String command;
        while (!"END".equals(command=reader.readLine())){
            tokens=command.split(" ");
            if (!validateCommand(tokens,matrix)){
                System.out.println("Invalid input!");
                continue;
            }
            int x1 = Integer.parseInt(tokens[1]);
            int y1 = Integer.parseInt(tokens[2]);
            int x2 = Integer.parseInt(tokens[3]);
            int y2 = Integer.parseInt(tokens[4]);
            swapElements(x1,y1,x2,y2,matrix);
            printMatrix(matrix);
        }



    }

    private static void swapElements(int x1, int y1, int x2, int y2, String[][] matrix) {
        String temp = matrix[x1][y1];
        matrix[x1][y1]=matrix[x2][y2];
        matrix[x2][y2]=temp;
    }

    private static boolean validateCommand(String[] tokens, String[][] matrix) {
        if (tokens.length!=5 || !"swap".equals(tokens[0])){
            return false;
        }
        try{
            int x1 = Integer.parseInt(tokens[1]);
            int y1 = Integer.parseInt(tokens[2]);
            int x2 = Integer.parseInt(tokens[3]);
            int y2 = Integer.parseInt(tokens[4]);
            String elementA = matrix[x1][y1];
            String elementB = matrix[x2][y2];
        } catch (Exception e){
            return false;
        }
        return true;
    }

    private static void fillMatrix(BufferedReader reader, String[][] matrix) throws IOException {
        for (int r = 0; r < matrix.length; r++) {
            matrix[r]=reader.readLine().split(" ");
        }
    }


    private static void printMatrix(String[][] matrix) {
        for (String[] row : matrix) {
            for (String element: row) {
                System.out.print(element+" ");
            }
            System.out.println();
        }
    }
}
