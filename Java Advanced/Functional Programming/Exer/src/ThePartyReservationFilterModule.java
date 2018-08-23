import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> guests = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayList::new));

        Map<String,HashSet<String>> filters = new HashMap<>();

        String line;
        while (true){
            line=reader.readLine();
            if ("Print".equals(line)){
                break;
            }
            String[] tokens = line.split(";");
            String command = tokens[0];
            switch (command){
                case "Add filter":
                    for (int i = 1; i < tokens.length; i++) {
                        addFilter(filters,tokens[i],tokens[i+1]);
                        i++;
                    }
                    break;
                case "Remove filter":
                    for (int i = 1; i < tokens.length; i++) {
                        removeFilter(filters,tokens[i],tokens[i+1]);
                        i++;
                    }
                    break;
            }
        }



        for (String guest:guests) {
            if (!applyFilter(guest,filters))
            System.out.printf("%s ",guest);
        }
    }

    private static boolean applyFilter(String guest,
                                       Map<String,HashSet<String>> filters) {
        boolean passFilter=false;
        FiltersLoop:
        for (String filterType:filters.keySet()) {
            for (String filterParameter:filters.get(filterType)) {
                switch (filterType){
                    case "Starts with":
                        passFilter=guest.startsWith(filterParameter);
                        break;
                    case "Ends with":
                        passFilter=guest.endsWith(filterParameter);
                        break;
                    case "Length":
                        int lenght = Integer.parseInt(filterParameter);
                        passFilter=guest.length()>lenght;
                        break;
                    case "Contains":
                        passFilter=guest.contains(filterParameter);
                        break;
                }
                if (passFilter){
                    break FiltersLoop;
                }
            }
        }

        return passFilter;
    }

    private static void removeFilter(Map<String,HashSet<String>> filters,
                                     String filterType,
                                     String filterParameter) {
        if (!filters.containsKey(filterType)){
            return;
        }
        filters.get(filterType).remove(filterParameter);
        if (filters.get(filterType).size()==0){
            filters.remove(filterType);
        }
    }

    private static void addFilter(Map<String,HashSet<String>> filters,
                                  String filterType,
                                  String filterParameter) {
        if (!filters.containsKey(filterType)){
            filters.put(filterType, new HashSet<>());
        }
        filters.get(filterType).add(filterParameter);
    }
}
