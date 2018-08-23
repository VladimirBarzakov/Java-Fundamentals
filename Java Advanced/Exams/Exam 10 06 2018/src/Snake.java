import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Snake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        BigInteger foodCount =BigInteger.ZERO;
        BigInteger snakeLength =BigInteger.ONE;

        int[] snakePos = new int [2];
        ArrayDeque<String> movesList = Arrays.stream(
                reader.readLine().split(", "))
                .collect(Collectors.toCollection(ArrayDeque::new));
        String[][] matrix = new String[n][];
        for (int r = 0; r < n; r++) {
            matrix[r] = reader.readLine().split("\\s+");
            for (int c = 0; c < matrix[r].length; c++) {
                if ("f".equals(matrix[r][c])){
                    foodCount=foodCount.add(BigInteger.ONE);
                } else if("s".equals(matrix[r][c])){
                    matrix[r][c]="*";
                    snakePos[0]=r;
                    snakePos[1]=c;
                }
            }
        }

        while (!movesList.isEmpty()){
            String move = movesList.removeFirst();
            switch (move){
                case "up":
                    if ((snakePos[0]-1)<0){
                        snakePos[0]=n-1;
                    } else{
                        snakePos[0]=snakePos[0]-1;
                    }
                    break;
                case "down":
                    snakePos[0]=(snakePos[0]+1)%n;
                    break;
                case "right":
                    snakePos[1]=(snakePos[1]+1)%n;
                    break;
                case "left":
                    if ((snakePos[1]-1)<0){
                        snakePos[1]=n-1;
                    } else{
                        snakePos[1]=snakePos[1]-1;
                    }
                    break;
            }
            if (isKilled(matrix,snakePos)){
                System.out.println("You lose! Killed by an enemy!");
                return;
            }
            snakeLength=getFood(matrix,snakePos,snakeLength);
        }
        if (snakeLength.subtract(foodCount).equals(BigInteger.ONE)){
            System.out.printf("You win! Final snake length is %d",snakeLength);
        } else{
            System.out.printf("You lose! There is still %d food to be eaten.",foodCount.subtract(
                    snakeLength.subtract(BigInteger.ONE)));
        }
    }

    private static BigInteger getFood(String[][] matrix, int[] snakePos, BigInteger snakeLength) {
        if ("f".equals(matrix[snakePos[0]][snakePos[1]])){
            snakeLength=snakeLength.add(BigInteger.ONE);
            matrix[snakePos[0]][snakePos[1]]="*";
        }
        return snakeLength;
    }

    private static boolean isKilled(String[][] matrix, int[] snakePos) {
        return "e".equals(matrix[snakePos[0]][snakePos[1]]);
    }
}
