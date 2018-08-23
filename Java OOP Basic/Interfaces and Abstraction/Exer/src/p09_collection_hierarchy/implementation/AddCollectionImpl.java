package p09_collection_hierarchy.implementation;

import p09_collection_hierarchy.interfaces.AddCollection;

import java.util.ArrayDeque;

public class AddCollectionImpl implements AddCollection {

    private int size;
    private ArrayDeque<String> collection;

    public AddCollectionImpl() {
        this.collection = new ArrayDeque<>();
        this.size=-1;
    }

    @Override
    public int add(String element) {
        this.size++;
        this.collection.addLast(element);
        return this.size;
    }
}
