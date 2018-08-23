import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MelrahShake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String toShake = reader.readLine();
        String patern = reader.readLine();

        while (true)
        {
            int firsOccurrence = toShake.indexOf(patern);
            int lastOccurrence = toShake.lastIndexOf(patern);
            int len = patern.length();
            if (firsOccurrence!=-1
                    && lastOccurrence!=-1
                    && firsOccurrence!=lastOccurrence
                    && len!=0
                    && toShake.length()>=len*2)
            {

                toShake = new StringBuilder(toShake).delete(lastOccurrence,lastOccurrence+len).toString();
                toShake = new StringBuilder(toShake).delete(firsOccurrence,firsOccurrence+len).toString();
                System.out.println("Shaked it.");
                patern = new StringBuilder(patern).delete(len/2,(len/2)+1).toString();
            }
            else
            {
                System.out.println("No shake.");
                System.out.println(toShake);
                return;
            }
        }
    }
}
