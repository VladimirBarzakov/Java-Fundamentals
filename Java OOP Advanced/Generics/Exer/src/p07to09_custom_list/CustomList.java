package p07to09_custom_list;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class CustomList<T extends Comparable> implements Iterable {
    private List<T> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }
    public	void add(T element){
        this.list.add(element);
    }

    public T remove(int index){
        if (index<0 || index>=this.list.size()){
            throw new IllegalArgumentException();
        }
        return this.list.remove(index);
    }
    public boolean contains(T element){
        for (T member:this.list) {
            if (member.equals(element)){
                return true;
            }
        }
        return false;
    }
    
    public void swap(int indexA, int indexB){
        T temp = this.list.get(indexA);
        this.list.set(indexA, this.list.get(indexB));
        this.list.set(indexB,temp);
    }

    public int countGreaterThan(T element){
        int counter =0;
        for (T member:this.list) {
            if (element.compareTo(member)<0){
                counter++;
            }
        }
        return counter;
    }
    public T getMax(){
        if (this.list.size()==0){
            throw new IllegalArgumentException();
        }
        T max = this.list.get(0);
        for (int i = 1; i < this.list.size(); i++) {
            if (max.compareTo(this.list.get(i))<0){
                max=this.list.get(i);
            }
        }
        return max;
    }
    public	T getMin(){
        if (this.list.size()==0){
            throw new IllegalArgumentException();
        }
        T min = this.list.get(0);
        for (int i = 1; i < this.list.size(); i++) {
            if (min.compareTo(this.list.get(i))>0){
                min=this.list.get(i);
            }
        }
        return min;
    }

    public <T extends Comparable>void sort(){
        this.list=this.list.stream().sorted().collect(Collectors.toList());
    }


    @Override
    public Iterator<T> iterator() {
        return this.list.iterator();
    }

    @Override
    public void forEach(Consumer action) {
        Objects.requireNonNull(action);
        for (T t : this.list) {
            action.accept(t);
        }
    }

    @Override
    public Spliterator spliterator() {
        return null;
    }
}
