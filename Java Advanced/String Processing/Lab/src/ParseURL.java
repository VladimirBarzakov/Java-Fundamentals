import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParseURL {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens =reader.readLine().split("://");
        if (tokens.length!=2){
            System.out.println("Invalid URL");
            return;
        }
        String protokol = tokens[0];
        int endServerNameIndex = tokens[1].indexOf('/');
        if (endServerNameIndex==-1){
            System.out.println("Invalid URL");
            return;
        }
        String server = tokens[1].substring(0,endServerNameIndex);
        String resources="";
        if (tokens[1].split("/").length>1) {
            resources = tokens[1].substring(endServerNameIndex + 1);
        }
        System.out.printf("Protocol = %s%n",protokol);
        System.out.printf("Server = %s%n",server);
        System.out.printf("Resources = %s%n",resources);
    }
}
