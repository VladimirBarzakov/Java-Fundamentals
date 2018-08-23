import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LittleJohn {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> input = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            input.add(reader.readLine());
        }
        Long[] arrowsCount = new Long[3];
        for (int i = 0; i < 3; i++) {
            arrowsCount[i]=0L;
        }
        Pattern largeArrowPtr = Pattern.compile(">>>----->>");
        Pattern mediumArrowPtr  =Pattern.compile(">>----->");
        Pattern smallArrowPtr = Pattern.compile(">----->");

        input.forEach(x->{
            Matcher matcher = largeArrowPtr.matcher(x);
            while (matcher.find()){
                arrowsCount[2]++;
            }
            x = x.replaceAll(">>>----->>","aaaaaaaaaaa");
            matcher = mediumArrowPtr.matcher(x);
            while (matcher.find()){
                arrowsCount[1]++;
            }
            x = x.replaceAll(">>----->","aaaaaaaa");
            matcher=smallArrowPtr.matcher(x);
            while (matcher.find()){
                arrowsCount[0]++;
            }
        });
        StringBuilder res = new StringBuilder(Integer.toBinaryString(Integer.parseInt(
                Arrays.toString(arrowsCount).replaceAll("[\\[\\], ]",""))));

        String str = res.toString()+res.reverse().toString();
        Long message = Long.parseLong(str,2);
        System.out.println(message);
    }
}
