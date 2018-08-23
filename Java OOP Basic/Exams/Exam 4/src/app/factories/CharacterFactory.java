package app.factories;

import app.contracts.ComicCharacter;
import app.entities.antiHeroes.Titan;
import app.entities.antiHeroes.Villain;
import app.entities.heroes.DCHero;
import app.entities.heroes.MarvelHero;

public final class CharacterFactory {

    public static ComicCharacter generateCharacter(String[] tokens){
        ComicCharacter character = null;
        String name = tokens[0];
        String type = tokens[1];
        int energy = Integer.parseInt(tokens[2]);
        double health = Double.parseDouble(tokens[3]);
        double intelligence = Double.parseDouble(tokens[4]);
        double specialParam = Double.parseDouble(tokens[5]);
        switch (type){
            case "MarvelHero":
                character=new MarvelHero(name,energy,health,intelligence,specialParam);
                break;
            case "DCHero":
                character=new DCHero(name,energy,health,intelligence,specialParam);
                break;
            case "Villain":
                character=new Villain(name,energy,health,intelligence,specialParam);
                break;
            case "Titan":
                character=new Titan(name,energy,health,intelligence,specialParam);
                break;
        }
        return character;
    }
}
