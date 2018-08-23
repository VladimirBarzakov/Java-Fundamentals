import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> vip = new HashSet<>();
        TreeSet<String> regularGuests = new TreeSet<>();
        String line;
        boolean isPartyStarted = false;
        while (!"END".equals(line=reader.readLine().trim())){
            if ("PARTY".equals(line)){
                isPartyStarted=true;
                continue;
            }
            if (!isPartyStarted){
                if(Character.isDigit(line.charAt(0))){
                    vip.add(line);
                } else{
                    regularGuests.add(line);
                }
            } else{
                if(Character.isDigit(line.charAt(0))){
                    vip.remove(line);
                } else{
                    regularGuests.remove(line);
                }
            }
        }

        System.out.println(vip.size()+regularGuests.size());
        for (String id:vip) {
            System.out.println(id);
        }
        for (String id:regularGuests) {
            System.out.println(id);
        }
    }
}
