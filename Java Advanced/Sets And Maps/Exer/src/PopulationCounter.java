import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class PopulationCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, LinkedHashMap<String, Long>> populationByCountry = new LinkedHashMap<>();
        LinkedHashMap<String, Long>  countriesPopulation = new LinkedHashMap<>();
        String line;
        while (!"report".equals(line=reader.readLine())){
            String[] tokens = line.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            Long population = Long.parseLong(tokens[2]);
            if (!populationByCountry.containsKey(country)){
                populationByCountry.put(country, new LinkedHashMap<>());
            }
            if (!populationByCountry.get(country).containsKey(city)){
                populationByCountry.get(country).put(city,0L);
            }
            populationByCountry.get(country).put(
                    city,populationByCountry.get(country).get(city)+population);
            if (!countriesPopulation.containsKey(country)){
                countriesPopulation.put(country,0L);
            }
            countriesPopulation.put(country,countriesPopulation.get(country)+population);
        }

        for (String country: countriesPopulation.keySet().stream().sorted(
                (x,y)->countriesPopulation.get(y).compareTo(countriesPopulation.get(x))).collect(Collectors.toCollection(LinkedHashSet::new)) ) {

            System.out.printf("%s (total population: %d)%n",country,countriesPopulation.get(country));
            for (String city:populationByCountry.get(country).keySet().stream()
                    .sorted((x,y)->populationByCountry.get(country).get(y).compareTo(
                    populationByCountry.get(country).get(x)) )
                    .collect(Collectors.toCollection(LinkedHashSet::new))) {
                System.out.printf("=>%s: %d%n",city,populationByCountry.get(country).get(city));
            }

        }
    }
}
