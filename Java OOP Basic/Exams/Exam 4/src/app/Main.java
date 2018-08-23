package app;

import app.contracts.Arena;
import app.contracts.ComicCharacter;
import app.contracts.Manager;
import app.contracts.SuperPower;
import app.controller.WarManager;
import app.entities.ArenaImpl;
import app.entities.Power;
import app.factories.CharacterFactory;
import app.io.InputReader;
import app.io.OutputWriter;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        InputReader reader = new InputReader();
        OutputWriter writer = new OutputWriter();
        Manager manager = new WarManager();

        String line;

        Loop:
        while (true){
            String result = null;
            line=reader.readLine();
            String[] tokens = line.split("\\s+");
            String command = tokens[0];
            switch (command){
                case "CHECK_CHARACTER":
                    result=manager.checkComicCharacter(tokens[1]);
                    break;
                case "REGISTER_HERO":
                    ComicCharacter character=null;
                    try {
                        character = CharacterFactory.generateCharacter(
                                Arrays.stream(tokens).skip(1).toArray(String[]::new));
                    } catch (IllegalArgumentException e){
                        result=e.getMessage();
                    }
                    if (character!=null){
                       result=manager.addHero(character);
                    }
                    break;
                case "REGISTER_ANTI_HERO":
                    character=null;
                    try {
                        character = CharacterFactory.generateCharacter(
                                Arrays.stream(tokens).skip(1).toArray(String[]::new));
                    } catch (IllegalArgumentException e){
                        result=e.getMessage();
                    }
                    if (character!=null){
                        result=manager.addAntiHero(character);
                    }
                    break;
                case "BUILD_ARENA":
                    String arenaName = tokens[1];
                    int arenaCapacity = Integer.parseInt(tokens[2]);
                    try {
                        Arena arena1 = new ArenaImpl(arenaName, arenaCapacity);
                        result=manager.addArena(arena1);
                    } catch (IllegalArgumentException e){
                        result=e.getMessage();
                    }
                    break;
                case "SEND_HERO":
                    result = manager.addHeroToArena(tokens[1],tokens[2]);
                    break;
                case "SEND_ANTI_HERO":
                    result = manager.addAntiHeroToArena(tokens[1],tokens[2]);
                    break;
                case "SUPER_POWER":
                    String powerName = tokens[1];
                    double powerPoints = Double.parseDouble(tokens[2]);
                    SuperPower superPower = null;
                    try {
                        superPower=new Power(powerName,powerPoints);
                        result=manager.loadSuperPowerToPool(superPower);
                    }catch (IllegalArgumentException e){
                        result=e.getMessage();
                    }
                    break;
                case "ASSIGN_POWER":
                    result=manager.assignSuperPowerToComicCharacter(tokens[1],tokens[2]);
                    break;
                case "UNLEASH":
                    result=manager.usePowers(tokens[1]);
                    break;
                case "COMICS_WAR":
                    result=manager.startBattle(tokens[1]);
                    break;
                case "WAR_IS_OVER":
                    result=manager.endWar();
                    writer.writeLine(result);
                    reader.close();
                    break Loop;
            }
            if (result!=null){
                writer.writeLine(result);
            }
        }

    }
}
