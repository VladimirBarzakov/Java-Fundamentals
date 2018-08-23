package p07to09_custom_list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CustomList<String> list = new CustomList<>();

        String line;
        while (true){
            line=reader.readLine();
            if ("END".equals(line)){
                break;
            }
            String[] tokens = line.split("\\s+");
            String command = tokens[0];
            switch (command){
                case "Add":
                    String element = tokens[1];
                    list.add(element);
                    break;
                case "Remove":
                    int index = Integer.parseInt(tokens[1]);
                    list.remove(index);
                    break;
                case "Contains":
                    element = tokens[1];
                    System.out.println(Boolean.toString(list.contains(element)).toLowerCase());
                    break;
                case "Swap":
                    int index1 = Integer.parseInt(tokens[1]);
                    int index2 = Integer.parseInt(tokens[2]);
                    list.swap(index1,index2);
                    break;
                case "Greater":
                    element = tokens[1];
                    System.out.println(list.countGreaterThan(element));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Sort":
                    list.sort();
                    break;
                case "Print":
                    Iterator iterator = list.iterator();
                    while (iterator.hasNext()){
                        System.out.println(iterator.next());
                    }
                    break;
            }
        }
        
    }
}
