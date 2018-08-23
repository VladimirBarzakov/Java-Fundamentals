package p09_collection_hierarchy.implementation;

import p09_collection_hierarchy.interfaces.AddRemoveCollection;

import java.util.ArrayDeque;

public class AddRemoveCollectionImpl implements AddRemoveCollection {

    private int size;
    private ArrayDeque<String> collection;

    public AddRemoveCollectionImpl() {
        this.collection = new ArrayDeque<>();
        this.size=-1;
    }

    @Override
    public String remove() {
        if (this.size>-1){
            this.size--;
            return this.collection.removeFirst();
        }
        return null;
    }

    @Override
    public int add(String element) {
        this.size++;
        this.collection.addLast(element);
        return 0;
    }
}
