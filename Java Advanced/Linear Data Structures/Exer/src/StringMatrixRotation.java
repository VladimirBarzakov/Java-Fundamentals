import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StringMatrixRotation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int rotateAngle=extractAngle(reader.readLine());
        String line;
        List<String> tokens = new ArrayList<>();
        int maxStringLength = 0;
        while (!"END".equals(line=reader.readLine())){
            if (line.length()>maxStringLength){
                maxStringLength=line.length();
            }
            tokens.add(line);
        }
        String[][] matrix = new String[tokens.size()][maxStringLength];
        fillMatrix(tokens,matrix);
        switch (rotateAngle%360){
            case 0:
                printMatrix(matrix);
                break;
            case 90:
                printMatrixUpDown(matrix);
                break;
            case 180:
                printMatrixRightToLeft(matrix);
                break;
            case 270:
                printMatrixDownUp(matrix);
                break;
        }


    }

    private static void printMatrixDownUp(String[][] matrix) {
        for (int c = matrix[0].length-1; c>=0;c--){
            for (int r  = 0; r < matrix.length; r++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }

    private static void printMatrixRightToLeft(String[][] matrix) {
        for (int r = matrix.length-1; r >=0; r--) {
            for (int c = matrix[r].length-1; c >= 0; c--) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }

    private static void printMatrixUpDown(String[][] matrix) {
        for (int c = 0; c<matrix[0].length;c++){
            for (int r  = matrix.length-1; r >= 0; r--) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }

    }

    private static void printMatrix(String[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }

    private static int extractAngle(String s) {
        int firstIndex = s.indexOf("(");
        int result = Integer.parseInt(s.substring(firstIndex+1,s.length()-1));
        return result;
    }

    private static void fillMatrix(List<String> tokens, String[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (c<tokens.get(r).length()){
                    matrix[r][c]=String.valueOf(tokens.get(r).charAt(c));
                } else{
                    matrix[r][c]=" ";
                }

            }

        }
    }
}
