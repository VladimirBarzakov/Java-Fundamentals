import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SeriesOfLetters {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] input = reader.readLine().toCharArray();

        int state = 0;
        char prev = input[0];
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < input.length; i++) {
            switch (state){
                case 0:
                    state=1;
                    prev = input[i];
                    break;
                case 1:
                    output.append(input[i-1]);
                    if (input[i]==prev){
                        state=2;
                    }
                    prev=input[i];
                    break;
                case 2:
                    if (input[i]!=prev){
                        state=1;
                    }
                    prev=input[i];
                    break;
            }
            if (i==input.length-1){
                if (state!=2){
                    output.append(input[i]);
                }
            }
        }
        System.out.println(output.toString());
    }
}
