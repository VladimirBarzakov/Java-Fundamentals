import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Crossfire {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split("\\s+");
        int rows = Integer.parseInt(tokens[0]);
        int cols = Integer.parseInt(tokens[1]);
        List<List<Long>> matrix = new ArrayList<>();
        Long counter=1L;
        for (int r = 0; r <rows ; r++) {
            matrix.add(new ArrayList<>());
            for (int c = 0; c < cols; c++) {
                matrix.get(r).add(counter);
                counter++;
            }
        }

        String line;
        while (true){
            line=reader.readLine();
            if ("Nuke it from orbit".equals(line)){
                break;
            }
            tokens=line.split("\\s+");
            int x = Integer.parseInt(tokens[0]);
            int y = Integer.parseInt(tokens[1]);
            int radius = Integer.parseInt(tokens[2]);
            for (int r = x+radius; r >=x-radius; r--) {
                if (r>=0 && r<matrix.size() && y>=0 && y<matrix.get(r).size() && r!=x){
                    matrix.get(r).remove(y);
                }
            }
            for (int c = y+radius; c >=y-radius ; c--) {
                if (x>=0 && x < matrix.size() && c >= 0 && c < matrix.get(x).size() ){
                    matrix.get(x).remove(c);
                }
            }

            for (int i = matrix.size()-1; i >=0 ; i--) {
                if (matrix.get(i).isEmpty()){
                    matrix.remove(i);
                }
            }

        }

        for (List<Long> row:matrix) {
            for (Long element:row) {
                System.out.printf("%d ",element);
            }
            System.out.println();
        }
    }
}
