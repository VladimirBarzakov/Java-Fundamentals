package p08_pokémon_trainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Trainer> trainers = new LinkedHashMap<>();
        String line;
        while (true){
            line=reader.readLine();
            if ("Tournament".equals(line)){
                break;
            }
            String[] token = line.split("\\s+");
            String trainerName = token[0];
            String pokemonName = token[1];
            String pokemonElement = token[2];
            long pokemonHealth = Long.parseLong(token[3]);
            Pokemon pokemon = new Pokemon(pokemonName,pokemonElement,pokemonHealth);
            if (!trainers.containsKey(trainerName)){
                trainers.put(trainerName,new Trainer(trainerName));
            }
            trainers.get(trainerName).addPokemon(pokemon);
        }
        while (true){
            line=reader.readLine();
            if ("End".equals(line)){
                break;
            }
            String element = line;
            trainers.values().stream().forEach(x->{
                if (x.containsPokemonOfElement(element)){
                    x.incrementBadges();
                } else{
                    x.decreaseHealth();
                }
            });
        }
        trainers.values().stream()
                .sorted(Comparator.comparing(Trainer::getNumberOfBadges).reversed())
                .forEach(System.out::println);

    }
}
