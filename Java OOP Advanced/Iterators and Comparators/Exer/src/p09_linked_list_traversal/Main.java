package p09_linked_list_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        MyLinkList<Integer> list = new MyLinkList<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String command = tokens[0];
            int number = Integer.parseInt(tokens[1]);
            switch (command){
                case "Add":
                    list.add(number);
                    break;
                case "Remove":
                    list.remove(number);
                    break;
            }
        }
        System.out.println(list.getSize());
        list.forEach(x-> System.out.print(x+" "));
    }
}
