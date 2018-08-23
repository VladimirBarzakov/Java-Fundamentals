package p08_pokémon_trainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private long numberOfBadges=0;
    private List<Pokemon> pokemons;

    public Trainer() {
        this.pokemons=new ArrayList<>();
    }

    public Trainer(String name){
        this();
        this.name=name;
    }

    public void addPokemon(Pokemon pokemon){
        this.pokemons.add(pokemon);
    }

    public boolean containsPokemonOfElement(String element){
        return this.pokemons.stream().anyMatch(x->x.getElement().equals(element));
    }

    public void incrementBadges(){
        this.numberOfBadges++;
    }

    public long getNumberOfBadges() {
        return this.numberOfBadges;
    }

    public void decreaseHealth(){
        this.pokemons.forEach(Pokemon::decreseHealth);
        for (int i = this.pokemons.size()-1; i >=0; i--) {
            if (this.pokemons.get(i).getHealth()<=0){
                this.pokemons.remove(i);
            }
        }
    }
    @Override
    public String toString(){
       return String.format("%s %d %d",this.name,this.numberOfBadges,this.pokemons.size());
    }

}
