package app.entities;

import app.constants.ExceptionMessages;
import app.contracts.Arena;
import app.contracts.ComicCharacter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ArenaImpl implements Arena {
    private String name;
    private Map<String, ComicCharacter> antiHeroes;
    private Map<String, ComicCharacter> heroes;
    private int capacity;

    public ArenaImpl(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.antiHeroes=new LinkedHashMap<>();
        this.heroes=new LinkedHashMap<>();
    }

    @Override
    public String getArenaName() {
        return this.name;
    }

    @Override
    public boolean isArenaFull() {
        return (this.antiHeroes.size()+this.heroes.size())==this.capacity;
    }

    @Override
    public void addHero(ComicCharacter hero) {

        if (this.isArenaFull()){
            throw new IllegalArgumentException(ExceptionMessages.ILLEGAL_ADD_TO_FULL_ARENA_MESSAGE);
        }
        if (hero.getHealth()<=0){
            throw new IllegalArgumentException(String.format(ExceptionMessages.ILLEGAL_ADD_DEAD_CHARACTER_MESSAGE,
                    hero.getName()));
        }
        if (this.heroes.containsKey(hero.getName())){
            throw new IllegalArgumentException(String.format(ExceptionMessages.ILLEGAL_HERO_TO_ARENA_MESSAGE,
                    hero.getName()));
        }
        this.heroes.put(hero.getName(), hero);
    }

    @Override
    public void addAntiHero(ComicCharacter antiHero) {

        if (this.isArenaFull()){
            throw new IllegalArgumentException(ExceptionMessages.ILLEGAL_ADD_TO_FULL_ARENA_MESSAGE);
        }
        if (this.antiHeroes.containsKey(antiHero.getName())){
            throw new IllegalArgumentException(String.format(ExceptionMessages.ILLEGAL_ANTIHERO_TO_ARENA_MESSAGE,
                    antiHero.getName()));
        }
        if (antiHero.getHealth()<=0){
            throw new IllegalArgumentException(String.format(ExceptionMessages.ILLEGAL_ADD_DEAD_CHARACTER_MESSAGE,
                    antiHero.getName()));
        }
        this.antiHeroes.put(antiHero.getName(), antiHero);

    }

    @Override
    public boolean fightHeroes() {
        if (this.antiHeroes.size()==0 && this.heroes.size()==0){
            throw new IllegalArgumentException(ExceptionMessages.ILLEGAL_EMPTY_ARENA_MESSAGE);
        }
        List<ComicCharacter> firstTeam;
        List<ComicCharacter> secondTeam;
        boolean isHeroesTeamSmaller = this.heroes.size()<=this.antiHeroes.size();
        if (isHeroesTeamSmaller){
            firstTeam= new ArrayList<>(this.heroes.values());
            secondTeam=new ArrayList<>(this.antiHeroes.values());
        } else{
            firstTeam= new ArrayList<>(this.antiHeroes.values());
            secondTeam=new ArrayList<>(this.heroes.values());
        }
        while (true){
            if (firstTeam.size()==0){
                break;
            }
            int counter = Math.min(firstTeam.size(), secondTeam.size());
            for (int i = 0; i < counter; i++) {
                secondTeam.get(i).takeDamage(firstTeam.get(i).attack());
            }
            for (int i = secondTeam.size()-1; i >=0 ; i--) {
                if (secondTeam.get(i).getHealth()<=0){
                    if (isHeroesTeamSmaller){
                        this.antiHeroes.remove(secondTeam.get(i).getName());
                    } else{
                        this.heroes.remove(secondTeam.get(i).getName());
                    }
                    secondTeam.remove(i);
                }
            }

            if (secondTeam.size()==0){
                break;
            }
            counter = Math.min(firstTeam.size(), secondTeam.size());
            for (int i = 0; i < counter; i++) {
                firstTeam.get(i).takeDamage(secondTeam.get(i).attack());
            }
            for (int i = firstTeam.size()-1; i >=0 ; i--) {
                if (firstTeam.get(i).getHealth()<=0){
                    if (isHeroesTeamSmaller){
                        this.heroes.remove(secondTeam.get(i).getName());
                    } else{
                        this.antiHeroes.remove(secondTeam.get(i).getName());
                    }
                    firstTeam.remove(i);
                }
            }
        }

        if (this.antiHeroes.size()==0){
            return true;
        } else{
            return false;
        }
    }

}
