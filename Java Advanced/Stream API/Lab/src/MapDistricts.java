import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class MapDistricts {

    static class City{
        private String name;
        private Long population;
        private List<Long> districts;

        City(String name) {
            this.population=0L;
            this.districts = new ArrayList<>();
        }

        public String getName() {
            return name;
        }


        Long getPopulation() {
            if (this.districts.isEmpty()){
                return 0L;
            }
            return this.districts.stream().reduce((x,y)->x+y).get();
        }

        List<Long> getDistricts() {
            return districts;
        }

        void addDistricts(Long district) {
            this.districts.add(district);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        Map<String, City> cities = new HashMap<>();

        Arrays.stream(reader.readLine().split("\\s+")).forEach(x->{
            String cityName = x.split(":")[0];
            Long districtPopulation = Long.parseLong(x.split(":")[1]);
            if (!cities.containsKey(cityName)){
                cities.put(cityName,new City(cityName));
            }
            cities.get(cityName).addDistricts(districtPopulation);
        });

        Long populationLimit = Long.parseLong(reader.readLine());

        cities.entrySet().stream()
                .filter(x->x.getValue().getPopulation()>populationLimit)
                .sorted((x,y)->y.getValue().getPopulation().compareTo(x.getValue().getPopulation()))
                .forEach(x->{
                    builder.append(x.getKey()).append(": ");
                    x.getValue().getDistricts().stream()
                            .sorted(Comparator.reverseOrder())
                            .limit(5)
                            .forEach(y->builder.append(y).append(" "));
                    builder.append(System.lineSeparator());
                });
        System.out.println(builder);
    }
}
