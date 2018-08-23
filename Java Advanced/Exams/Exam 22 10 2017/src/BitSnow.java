import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BitSnow {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(reader.readLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
        Map<Integer, Integer> snowFlakes = new HashMap<>();



        for (int learIndex = nums.length-1; learIndex >=0 ; learIndex--) {
            for (int columnIndex = 0; columnIndex < 16; columnIndex++) {
                if ((nums[learIndex]>>columnIndex)%2!=0){
                    if (!snowFlakes.containsKey(columnIndex)){
                        snowFlakes.put(columnIndex,0);
                    }
                    snowFlakes.put(columnIndex,snowFlakes.get(columnIndex)+1);
                }
            }
        }

        int[][] matrix = new int[nums.length][];
        Set<Integer> rowsToDelete = new HashSet<>();
        for (int rowIndex = nums.length-1; rowIndex >=0 ; rowIndex--) {
            matrix[rowIndex] = new int[16];
            rowsToDelete.clear();
            for (Integer col:snowFlakes.keySet()) {
                if (snowFlakes.get(col)>0){
                    matrix[rowIndex][15-col]=1;
                    snowFlakes.put(col,snowFlakes.get(col)-1);
                } else{
                    rowsToDelete.add(col);
                }
            }
            for (Integer col:rowsToDelete) {
                snowFlakes.remove(col);
            }
            if (snowFlakes.isEmpty()){
                break;
            }
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (matrix[i]==null){
                result[i]=0;
            }else{
                result[i]=Integer.parseInt(Arrays.toString(matrix[i]).replaceAll("[\\[\\], ]",""),2);
            }

        }




        System.out.println(Arrays.toString(result).replaceAll("[\\[\\]]",""));
    }
}
