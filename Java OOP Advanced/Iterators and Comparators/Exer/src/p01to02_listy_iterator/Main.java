package p01to02_listy_iterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ListyIterator<String> list = null;
        String command;
        while (true){
            String[] tokens=reader.readLine().split("\\s+");
            command = tokens[0];
            if ("END".equals(command)){
                break;
            }
            switch (command){
                case "Create":
                    list=new ListyIterator<>(Arrays.stream(tokens).skip(1).toArray(String[]::new));
                    break;
                case "Move":
                    System.out.println(list.move());
                    break;
                case "Print":
                    list.print();
                    break;
                case "HasNext":
                    System.out.println(list.hasNext());
                    break;
                case "PrintAll":
                    list.printAll();
                    break;
            }
        }
    }
}
