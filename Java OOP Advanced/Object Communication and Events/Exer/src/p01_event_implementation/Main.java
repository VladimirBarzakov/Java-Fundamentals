package p01_event_implementation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Dispatcher dispatcher = new Dispatcher();
        Handler handler = new Handler();
        dispatcher.addNameChangeListener(handler);

        String line;
        while (true){
            line=scanner.nextLine();
            if ("End".equals(line)){
                break;
            }
            NameChange nameChangeEvent = new NameChange(line);
            dispatcher.fireNameChangeEvent(nameChangeEvent);
        }
    }
}
