import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SonarFence {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (true){
            line = reader.readLine();
            if ("Reprogram".equals(line)){
                break;
            }
            int num = Integer.parseInt(line);
            long result =num;
            for (int i = 0; i <= 30; i++) {
                long testNum = num>>(30-i);
                long testMask = 3;
                long mask=3;
                if (testNum%2==0 && (testNum>>1)%2==0){
                    mask=mask<<(30-i);
                    result=result|mask;
                    i++;
                } else{
                    if ((testNum&testMask)==3){
                        mask = ~(3<<(30-i));
                        result=result&mask;
                        i++;
                    }
                }
            }
            System.out.println(result);
        }
    }
}
