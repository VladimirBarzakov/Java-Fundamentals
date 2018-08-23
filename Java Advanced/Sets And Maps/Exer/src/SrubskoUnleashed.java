import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class SrubskoUnleashed {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, LinkedHashMap<String, Long>> concerts = new LinkedHashMap<>();
        String inLine = reader.readLine();

        while (!inLine.equals("End"))
        {
            String[] sepLine = Arrays.stream(inLine.split("@")).filter(x->x.length()!=0).toArray(String[]::new);
            String name = GetName(sepLine[0]);
            if (name.equals("badName!!"))
            {
                inLine = reader.readLine();
                continue;
            }
            String town = GetTown(sepLine[1]);
            if (town.endsWith("badName!!"))
            {
                inLine = reader.readLine();
                continue;
            }
            int[] financialSpecs = getFinancialSpecs(sepLine[1]);

            if (financialSpecs == null)
            {
                inLine = reader.readLine();
                continue;
            }
            int ticketPrice = financialSpecs[0];
            int ticketCount = financialSpecs[1];

            if (!concerts.containsKey(town))
            {
                concerts.put(town, new LinkedHashMap<>());
            }
            if (!concerts.get(town).containsKey(name)){
                concerts.get(town).put(name, 0L);
            }
            concerts.get(town).put(name,concerts.get(town).get(name)+ticketCount*ticketPrice);
            inLine = reader.readLine();
        }

        for (String venue: concerts.keySet()) {
            System.out.println(venue);
            for (String singer: concerts.get(venue).keySet().stream()
                    .sorted((x,y)-> concerts.get(venue).get(y).compareTo(concerts.get(venue).get(x)))
                    .collect(Collectors.toCollection(LinkedHashSet::new)) ) {
                System.out.printf("#  %s -> %d%n",singer,concerts.get(venue).get(singer));
            }
        }
    }

    private static int[] getFinancialSpecs(String v)
    {
        int index = 0;
        for (int i = 0; i < v.length(); i++)
        {
            if (!Character.isDigit(v.charAt(i))){
                index=i;
            }else {
                break;
            }
        }
        int[] price = Arrays.stream(v.substring(index).split(" ")).filter(x->x.length()!=0).mapToInt(Integer::parseInt).toArray();
        if (price.length != 2)
        {
            return null;
        }
        return price;
    }

    private static String GetTown(String v)
    {
        int index = 0;
        for (int i = 0; i < v.length(); i++)
        {
            if (!Character.isDigit(v.charAt(i))){
                index=i;
            }else {
                break;
            }
        }
        if (v.charAt(index)!=' ')
        {
            return "badName!!";
        }
        StringBuilder methCity = new StringBuilder();
        for (int i = 0; i < index; i++) {
            methCity.append(String.valueOf(v.charAt(i)));
        }
        if (methCity.toString().split(" ").length > 3)
        {
            return "badName!!";
        }
        return methCity.toString();
    }

    private static String GetName(String v)
    {
        if (!v.endsWith(" "))
        {
            return "badName!!";
        }
        v=v.trim();
        if (v.split(" ").length > 3)
        {
            return "badName!!";
        }
        return v;
    }
}
