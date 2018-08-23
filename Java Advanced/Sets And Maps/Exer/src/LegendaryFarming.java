import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class LegendaryFarming {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Long> keyMaterials = new HashMap<>();
        keyMaterials.put("shards",0L);
        keyMaterials.put("motes",0L);
        keyMaterials.put("fragments",0L);
        TreeMap<String, Long> junk = new TreeMap<>();
        Loop:
        while (true){
            String[] tokens = reader.readLine().split(" ");
            for (int i = 0; i < tokens.length; i++) {
                String material = tokens[i+1].toLowerCase();
                Long quantity = Long.parseLong(tokens[i]);
                if (keyMaterials.containsKey(material)){
                    if (!keyMaterials.containsKey(material)){
                        keyMaterials.put(material,0L);
                    }
                    keyMaterials.put(material,keyMaterials.get(material)+quantity);
                    if (keyMaterials.get(material)>=250){
                        switch (material){
                            case "shards":
                                System.out.println("Shadowmourne obtained!");
                                break;
                            case "fragments":
                                System.out.println("Valanyr obtained!");
                                break;
                            case "motes":
                                System.out.println("Dragonwrath obtained!");
                                break;
                        }
                        keyMaterials.put(material,keyMaterials.get(material)-250);
                        break Loop;
                    }

                } else{
                    if (!junk.containsKey(material)){
                        junk.put(material,0L);
                    }
                    junk.put(material,junk.get(material)+quantity);
                }
                i++;
            }
        }
        for (String material:keyMaterials.keySet().stream().sorted((x,y)->{
            int comparator = keyMaterials.get(y).compareTo(keyMaterials.get(x));
            if (comparator==0){
                comparator=x.compareTo(y);
            }
            return comparator;
        }).collect(Collectors.toCollection(LinkedHashSet::new)) ) {
            System.out.printf("%s: %d%n",material, keyMaterials.get(material));
        }
        for (String junkMaterial:junk.keySet()) {
            System.out.printf("%s: %d%n",junkMaterial, junk.get(junkMaterial));
        }


    }
}
