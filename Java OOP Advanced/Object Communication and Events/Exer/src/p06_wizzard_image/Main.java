package p06_wizzard_image;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split("\\s+");
        Wizzard wizzard = new Wizzard(tokens[0], Integer.parseInt(tokens[1]));
        while (true){
            tokens = scanner.nextLine().split("\\s+");
            if (tokens[0].equals("END")){
                break;
            }
            int index = Integer.parseInt(tokens[0]);
            String  command = tokens[1];
            switch (command){
                case "FIREBALL":
                    Wizzard.fireball(index);
                    break;
                case "REFLECTION":
                    Wizzard.reflection(index);
                    break;
            }
        }
    }

}
