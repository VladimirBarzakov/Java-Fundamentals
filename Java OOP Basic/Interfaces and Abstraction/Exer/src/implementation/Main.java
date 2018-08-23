package implementation;

import interfaces.Character;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens =reader.readLine().split(" \\| ");
        String name = tokens[0];
        String type = tokens[1];
        String specialPointsStr = tokens[2];
        int level = Integer.parseInt(tokens[3]);

        Character character = null;
        switch (type){
            case "Demon":
                character = new DemonImpl(name, type, Double.parseDouble(specialPointsStr), level);
                break;
            case "Archangel":
                character = new ArchangelImpl(name, type,Integer.parseInt(specialPointsStr), level);
                break;
        }
        if (character!=null){
            System.out.println(character.toString());
        }
    }
}
