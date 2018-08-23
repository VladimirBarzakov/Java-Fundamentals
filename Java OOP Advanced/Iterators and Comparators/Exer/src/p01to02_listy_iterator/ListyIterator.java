package p01to02_listy_iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListyIterator<T> implements Iterable<T>{
    private List<T> list;
    private int index;

    public ListyIterator(T... args) {
        this.list = Arrays.asList(args);
    }

    private boolean isInBound(int index){
        if (index>=0 && index<this.list.size()){
            return true;
        }
        return false;
    }

    public boolean move(){
        if (isInBound(this.index+1)){
            this.index++;
            return true;
        }
        return false;
    }

    public void print(){
        if (isInBound(this.index)){
            System.out.println(this.list.get(this.index));
        } else{
            System.out.println("Invalid Operation!");
        }
    }

    public boolean hasNext(){
        return isInBound(this.index+1);
    }

    public void printAll(){
        this.forEach(x-> System.out.print(x+" "));
        System.out.println();
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private final class ListIterator implements Iterator<T> {
        private int counter =0;

        @Override
        public boolean hasNext(){
            return isInBound(counter);
        }

        @Override
        public T next(){
            return list.get(this.counter++);
        }
    }
}
