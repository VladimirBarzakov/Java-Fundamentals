import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        TreeMap<String, double[]> students = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String name = reader.readLine();
            double[] scores = Arrays.stream(reader.readLine().split(" "))
                    .mapToDouble(Double::parseDouble).toArray();

            students.put(name, scores);
        }

        DecimalFormat df=new DecimalFormat("0.#####################");
        for (String name:students.keySet()) {
            double average =0;
            for (double v:students.get(name)) {
                average+=v;
            }
            average=average/students.get(name).length;
            System.out.printf("%s is graduated with %s%n",name,df.format(average));
        }
    }
}
