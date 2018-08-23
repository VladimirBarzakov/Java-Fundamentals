package p03_stack_iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Stack<T> implements Iterable<T>{
    private List<T> list;

    public Stack() {
        this.list=new ArrayList<>();
    }

    public void push(T... elements){
        this.list.addAll(Arrays.asList(elements));
    }

    public T pop(){
        if (this.list.size()==0){
            System.out.println("No elements");
            return null;
        }
        T element = this.list.remove(this.list.size()-1);
        return element;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private final class StackIterator implements Iterator<T>{
        int counter = list.size()-1;

        @Override
        public boolean hasNext() {
            return this.counter>=0;
        }

        @Override
        public T next() {
            return list.get(this.counter--);
        }
    }
}
