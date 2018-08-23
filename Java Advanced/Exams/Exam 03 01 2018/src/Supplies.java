import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Supplies {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numOfLines=0;
        long ammountOfFood=0;
        long ammountOfDrins=0;
        int numOfValidCrates=0;
        List<String> crates = new ArrayList<>();
        String line;
        StringBuilder builder = new StringBuilder();
        while (true){
            line=reader.readLine();
            if ("Collect".equals(line)){
                break;
            }
            builder.append(line);
            numOfLines++;
        }
        String inputLines = builder.toString();
        Pattern cratePattern = Pattern.compile("\\[.*?]");
        Matcher matcher = cratePattern.matcher(inputLines);
        while (matcher.find()){
            crates.add(matcher.group());
        }
        int n = crates.size()/numOfLines;
        Pattern validCratePattern = Pattern.compile("\\[#(?<supply>(\\d{" + n + "}|[a-z]{" + n + "}))(?<body>[a-zA-Z0-9\\s]*)#\\1]");
        for (String crateLine:crates) {
            matcher = validCratePattern.matcher(crateLine);
            while (matcher.find()){
                numOfValidCrates++;
                String type = matcher.group("supply");
                String content = matcher.group("body");
                long sum=0;

                if (Character.isDigit(type.charAt(0))){
                    Set<Character> uniqueContent = new HashSet<>();
                    for (int i = 0; i < content.length(); i++) {
                        uniqueContent.add(content.charAt(i));
                    }
                    for (Character c:uniqueContent) {
                        sum+=(int)c;
                    }
                    sum*=n;
                    ammountOfFood+=sum;
                } else{
                    long typeSym=0;
                    for (Character c:content.toCharArray()) {
                        sum+=(int)c;
                    }
                    for (int i = 0; i < type.length(); i++) {
                        typeSym+=(int)type.charAt(i);
                    }
                    sum*=typeSym;
                    ammountOfDrins+=sum;
                }
            }
        }
        if (numOfValidCrates==0){
            System.out.println("No supplies found!");
        } else{
            System.out.printf("Number of supply crates: %d%n",numOfValidCrates);
            System.out.printf("Amount of food collected: %d%n",ammountOfFood);
            System.out.printf("Amount of drinks collected: %d%n",ammountOfDrins);
        }
        //String debug="";
    }
}
