import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentResults {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split(" - ");
        String name = tokens[0];
        String[] strScores = tokens[1].split(", ");
        double JAdv = Double.parseDouble(strScores[0]);
        double OOP  = Double.parseDouble(strScores[1]);
        double AdvOOP = Double.parseDouble(strScores[2]);
        double average = (JAdv+OOP+AdvOOP)/3;

        System.out.printf("%1$-10s|%2$7s|%3$7s|%4$7s|%5$7s|%n","Name","JAdv","JavaOOP","AdvOOP","Average");
        System.out.printf("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f| %n",name,JAdv,OOP,AdvOOP,average);

    }
}
