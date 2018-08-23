package p01to06_generics;

import java.util.List;

public class Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void swapBoxes(Box<T> otherBox){
        T temp = otherBox.getValue();
        otherBox.setValue(this.getValue());
        this.setValue(temp);
    }

    public static  <T extends Comparable> int countGreater(List<Box<T>> list, T element){
        int counter =0;
        for (int i = 0; i < list.size(); i++) {
            if (element.compareTo(list.get(i).getValue())<0){
                counter++;
            }
        }
        return counter;
    }

    @Override
    public String toString() {
        return String.format("%s: %s",value.getClass().getName(),this.value);
    }
}
