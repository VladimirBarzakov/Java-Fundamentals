package p09_collection_hierarchy.implementation;

import p09_collection_hierarchy.interfaces.AddCollection;
import p09_collection_hierarchy.interfaces.AddRemoveCollection;
import p09_collection_hierarchy.interfaces.MyList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputElements = reader.readLine().split("\\s+");
        int n = Integer.parseInt(reader.readLine());

        AddCollection addCollection  =new AddCollectionImpl();
        AddRemoveCollection addRemoveCollection  = new AddRemoveCollectionImpl();
        MyList myList = new MyListImpl();

        for (int i = 0; i < inputElements.length; i++) {
            System.out.printf("%d ",addCollection.add(inputElements[i]));
        }
        System.out.println();
        for (int i = 0; i < inputElements.length; i++) {
            System.out.printf("%d ",addRemoveCollection.add(inputElements[i]));
        }
        System.out.println();
        for (int i = 0; i < inputElements.length; i++) {
            System.out.printf("%d ",myList.add(inputElements[i]));
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.printf("%s ",addRemoveCollection.remove());
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.printf("%s ",myList.remove());
        }
        System.out.println();

    }
}
