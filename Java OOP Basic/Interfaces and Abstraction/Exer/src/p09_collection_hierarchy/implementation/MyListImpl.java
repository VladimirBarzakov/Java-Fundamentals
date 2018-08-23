package p09_collection_hierarchy.implementation;

import p09_collection_hierarchy.interfaces.MyList;


import java.util.ArrayDeque;


public class MyListImpl implements MyList {

    private int size;
    private ArrayDeque<String> collection;

    public MyListImpl() {
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
        this.collection.addFirst(element);
        return 0;
    }

    @Override
    public int getUsed() {
        return this.size+1;
    }
}
