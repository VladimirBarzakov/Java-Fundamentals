import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumOfAllValues {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String keyString = reader.readLine();
        String startKey = findStartKey(keyString);
        String endKey = findEndKey(keyString);

        if (startKey.isEmpty()||endKey.isEmpty()){
            System.out.println("<p>A key is missing</p>");
            return;
        }
        String text = reader.readLine();
        //Pattern substrPattern = Pattern.compile("startKEY(?!endKEY)(.+?)endKEY");
        Pattern substrPattern = Pattern.compile(String.format(
                "%1$s(?!%2$s)(.+?)%2$s",startKey,endKey));
        System.out.println(substrPattern.toString());

        Matcher matcher = substrPattern.matcher(text);
        double sum =0;
        List<Double> nums = new ArrayList<>();
        while (matcher.find()){
            String subStr = matcher.group(1);
             extractNumbers(subStr,nums);

        }
    }

    private static void extractNumbers(String str, List<Double> nums) {
        boolean isNumber = false;
        boolean isDouble =false;
        int startIndex=-1;
        int endIndex=-1;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))){
                isNumber=true;
                if (startIndex==-1){
                    startIndex=i;
                }
            } else {
                if (isNumber && !isDouble && str.charAt(i)=='.'){
                    isDouble=true;
                }
            }
        }
    }

    private static String findStartKey(String keyString) {
        String startkey ="";
        for (int i = 0; i < keyString.length(); i++) {
            if (!Character.isLetter(keyString.charAt(i)) &&
                    keyString.charAt(i)!='_' ){
                if (Character.isDigit(keyString.charAt(i))){
                    startkey=keyString.substring(0,i);
                }
                break;
            }
        }
        return startkey;
    }

    private static String findEndKey(String keyString) {
        String endKey="";
        for (int i = keyString.length()-1; i >=0 ; i--) {
            if (!Character.isLetter(keyString.charAt(i)) &&
                    keyString.charAt(i)!='_' ){
                if (Character.isDigit(keyString.charAt(i))){
                    endKey=keyString.substring(i+1);
                }
                break;
            }

        }
        return endKey;
    }
}
