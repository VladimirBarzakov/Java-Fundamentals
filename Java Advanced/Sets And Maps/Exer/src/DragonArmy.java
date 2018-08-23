import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class DragonArmy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        HashMap<String,TreeMap<String, String>> type = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++)
        {
            String[] input = Arrays.stream(reader.readLine().split(" "))
                    .filter(x->x.length()!=0).toArray(String[]::new);
            String typeS = input[0];
            String nameS = input[1];
            Long damageS = 45L;
            if (!input[2].equals("null"))
            {
                damageS = Long.parseLong(input[2]);
            }
            Long healthS = 250L;
            if (!input[3].equals("null"))
            {
                healthS = Long.parseLong(input[3]);
            }
            Long armorS = 10L;
            if (!input[4].equals("null"))
            {
                armorS = Long.parseLong(input[4]);
            }
            if (!type.containsKey(typeS))
            {
                type.put(typeS, new TreeMap<>());
            }

            type.get(typeS).put(nameS,damageS + "|" + healthS + "|" + armorS);

        }

        for (String tpe : type.keySet())
        {
            double typeDamage = 0;
            double typeHealth = 0;
            double typeArmor = 0;
            for (String dra : type.get(tpe).keySet())
            {
                long[] stats = Arrays.stream(type.get(tpe).get(dra).split("\\|")).filter(x->x.length()!=0)
                        .mapToLong(Long::parseLong).toArray();
                typeDamage += stats[0];
                typeHealth += stats[1];
                typeArmor += stats[2];
            }
            typeDamage /= type.get(tpe).size();
            typeHealth /= type.get(tpe).size();
            typeArmor /= type.get(tpe).size();
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n",tpe,typeDamage,typeHealth,typeArmor);
            for (String dra : type.get(tpe).keySet())
            {
                long[] stats = Arrays.stream(type.get(tpe).get(dra).split("\\|")).filter(x->x.length()!=0)
                        .mapToLong(Long::parseLong).toArray();
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n",dra,stats[0],stats[1],stats[2]);
            }
        }
    }
}
