package app.controller;

import app.constants.ExceptionMessages;
import app.contracts.Arena;
import app.contracts.ComicCharacter;
import app.contracts.Manager;
import app.contracts.SuperPower;

import java.util.*;

public class WarManager implements Manager {
    /**
     * In the task it is not specify if the hero and antiHero can have same names. Since I ask the qvestor and
     *  have answer that there are no such test, I implement single Map. If there shout be duplicated names,
     *  there should be given order of printing information about them.
     */
    private Map<String, ComicCharacter> comicCharacters;
    private Map<String, Arena> arenas;
    private Map<String, SuperPower> superPowerPool;
    private Set<String> assignedPowers;
    private Set<String> assignedCharacters;
    private Map<String, List<String>> participantsByArena;
    private int battlesWonByHeroes;
    private int battlesWonByAntiHeroes;

    public WarManager() {
        this.comicCharacters=new LinkedHashMap<>();
        this.arenas=new LinkedHashMap<>();
        this.superPowerPool=new LinkedHashMap<>();
        this.assignedPowers=new LinkedHashSet<>();
        this.assignedCharacters=new LinkedHashSet<>();
        this.participantsByArena=new LinkedHashMap<>();
        this.battlesWonByHeroes=0;
        this.battlesWonByAntiHeroes=0;
    }

    @Override
    public String checkComicCharacter(String characterName) {
        if (!this.comicCharacters.containsKey(characterName)){
            return String.format("Sorry, fans! %s doesn't exist in our comics!",characterName);
        }
        if (this.comicCharacters.get(characterName).getHealth()<=0){
            return String.format("%s has fallen in battle!",characterName);
        }
        return this.comicCharacters.get(characterName).toString();
    }

    @Override
    public String addHero(ComicCharacter hero) {
        if (this.comicCharacters.containsKey(hero.getName())){
            this.comicCharacters.get(hero.getName()).boostCharacter(hero.getEnergy(),hero.getHealth(),hero.getIntelligence());
            return String.format("%s evolved!",hero.getName());
        } else{
            this.comicCharacters.put(hero.getName(),hero);
            return String.format("%s is ready for battle!",hero.getName());
        }
    }

    @Override
    public String addAntiHero(ComicCharacter antiHero) {
        if (this.comicCharacters.containsKey(antiHero.getName())){
            this.comicCharacters.get(antiHero.getName()).boostCharacter(antiHero.getEnergy(),antiHero.getHealth(),antiHero.getIntelligence());
            return String.format("%s is getting stronger!",antiHero.getName());
        } else{
            this.comicCharacters.put(antiHero.getName(),antiHero);
            return String.format("%s is ready for destruction!",antiHero.getName());
        }
    }

    @Override
    public String addArena(Arena arena) {
        if (this.arenas.containsKey(arena.getArenaName())){
            return "A battle is about to start there!";
        }
        this.arenas.put(arena.getArenaName(),arena);
        return String.format("%s is becoming a fighting ground!",arena.getArenaName());
    }

    @Override
    public String addHeroToArena(String arena, String hero) {
        Arena currentArena = this.arenas.get(arena);
        ComicCharacter currentHero = this.comicCharacters.get(hero);
        if (currentArena==null || currentHero==null){
            return null;
        }
        if (this.assignedCharacters.contains(hero)){
            return String.format(ExceptionMessages.ILLEGAL_HERO_TO_ARENA_MESSAGE,hero);
        }
        try {
            currentArena.addHero(currentHero);
            this.assignedCharacters.add(hero);
            if (!this.participantsByArena.containsKey(arena)){
                this.participantsByArena.put(arena, new ArrayList<>());
            }
            this.participantsByArena.get(arena).add(hero);
            return String.format("%s is fighting for your freedom in %s!",hero,arena);
        } catch (IllegalArgumentException e){
            return e.getMessage();
        }
    }

    @Override
    public String addAntiHeroToArena(String arena, String antiHero) {
        Arena currentArena = this.arenas.get(arena);
        ComicCharacter currentAntiHero = this.comicCharacters.get(antiHero);
        if (currentArena==null || currentAntiHero==null){
            return null;
        }
        if (this.assignedCharacters.contains(antiHero)){
            return String.format(ExceptionMessages.ILLEGAL_ANTIHERO_TO_ARENA_MESSAGE,antiHero);
        }
        try {
            currentArena.addAntiHero(currentAntiHero);
            this.assignedCharacters.add(antiHero);
            if (!this.participantsByArena.containsKey(arena)){
                this.participantsByArena.put(arena, new ArrayList<>());
            }
            this.participantsByArena.get(arena).add(antiHero);
            return String.format("%s and his colleagues are trying to take over %s!",antiHero,arena);
        } catch (IllegalArgumentException e){
            return e.getMessage();
        }
    }

    @Override
    public String loadSuperPowerToPool(SuperPower superPower) {
        if (this.superPowerPool.containsKey(superPower.getName())){
            return "This super power already exists!";
        }
        this.superPowerPool.put(superPower.getName(), superPower);
        return String.format("%s added to pool!",superPower.getName());
    }

    @Override
    public String assignSuperPowerToComicCharacter(String comicCharacter, String superPower) {
        ComicCharacter character = this.comicCharacters.get(comicCharacter);
        SuperPower superPower1 = this.superPowerPool.get(superPower);
        if (character==null || superPower1==null){
            return null;
        }
        if (this.assignedPowers.contains(superPower)){
            return String.format("%s already assigned!",superPower);
        }
        character.addSuperPower(superPower1);
        this.assignedPowers.add(superPower);
        return String.format("%s has a new super power!",comicCharacter);
    }

    @Override
    public String usePowers(String characterName) {
        ComicCharacter character = this.comicCharacters.get(characterName);
        if (character==null){
            return null;
        }
        return character.useSuperPowers();
    }

    @Override
    public String startBattle(String arena) {
        Arena arena1 = this.arenas.get(arena);
        if (arena1==null){
            return null;
        }
        try {
            boolean heroesWon = arena1.fightHeroes();
            for (String participantName:this.participantsByArena.get(arena)) {
                this.assignedCharacters.remove(participantName);
            }
            this.participantsByArena.remove(arena);
            this.arenas.remove(arena);
            if (heroesWon){
                this.battlesWonByHeroes+=1;
                return String.format("Heroes won the battle of %s!",arena);
            } else{
                this.battlesWonByAntiHeroes+=1;
                return String.format("Anti Heroes won the battle of %s!",arena);
            }
        } catch (IllegalArgumentException e){
            return e.getMessage();
        }
    }

    @Override
    public String endWar() {
        if (this.battlesWonByHeroes>=this.battlesWonByAntiHeroes){
            return String.format("After %d battles our FRIENDLY HEROES WON!",
                    this.battlesWonByAntiHeroes+this.battlesWonByHeroes);
        } else{
            return "WE ARE DOOMED!";
        }
    }

    @Override
    public String toString() {
        return "WarManager{" +
                "comicCharacters=" + comicCharacters +
                ", arenas=" + arenas +
                ", superPowerPool=" + superPowerPool +
                ", assignedPowers=" + assignedPowers +
                ", assignedCharacters=" + assignedCharacters +
                ", participantsByArena=" + participantsByArena +
                ", battlesWonByHeroes=" + battlesWonByHeroes +
                ", battlesWonByAntiHeroes=" + battlesWonByAntiHeroes +
                '}';
    }
}
