import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.stream.Collectors;

public class Initiative {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> stationDescription = new HashMap<>();
        stationDescription.put("Hydra","The Hydra station: Zoological Research.");
        stationDescription.put("Arrow","The Arrow station: Development of defensive strategies, and Intelligence gathering.");
        stationDescription.put("Flame","The Flame station: Communication.");
        stationDescription.put("Pearl","The Pearl station: Psychological Research and/or Observation.");
        stationDescription.put("Orchid","The Orchid station: Space-time manipulation research, disguised as a Botanical station.");

        Map<String, Map<Long, String>> stations = new HashMap<>();
        stations.put("Hydra",new HashMap<>());
        stations.put("Arrow",new HashMap<>());
        stations.put("Flame",new HashMap<>());
        stations.put("Pearl",new HashMap<>());
        stations.put("Orchid",new HashMap<>());

        String line;
        while (true){
            line = reader.readLine();
            if (line.equals("Recruit")){
                break;
            }
            String[] tokens = line.split(":");
            String name = tokens[0];
            Long facNumber = Long.parseLong(tokens[1]);
            String stationName = tokens[2];
            if (stations.containsKey(stationName)){
                stations.get(stationName).put(facNumber,name);
            }
        }

        line=reader.readLine();
        if ("DHARMA Initiative".equals(line)){
            for (String station:stations.keySet().stream().sorted((x,y)->{
                int comparator = stations.get(y).size()-stations.get(x).size();
                if (comparator==0){
                    comparator=x.compareTo(y);
                }
                return comparator;
            }).collect(Collectors.toCollection(LinkedHashSet::new))) {
                System.out.printf("The %s has %d DHARMA recruits in it.%n",station,
                        stations.get(station).size());
            }
        } else if (stations.containsKey(line)){
            System.out.println(stationDescription.get(line));
            if (stations.get(line).size()==0){
                System.out.println("No recruits.");
            } else {
                for (Long facNumber : stations.get(line).keySet().stream().sorted(Comparator.reverseOrder())
                        .collect(Collectors.toCollection(LinkedHashSet::new))) {
                    System.out.printf("###%s - %d%n", stations.get(line).get(facNumber), facNumber);
                }
            }
        } else{
            System.out.println("DHARMA Initiative does not have such a station!");
        }
    }
}
