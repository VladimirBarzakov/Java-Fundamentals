package P01_ExtendedArrayList;

import java.util.ArrayList;

public class ExtendedArrayList<T extends Comparable<T>> extends ArrayList<T> {
    public T max(){
        if (this.size()==0){
            return null;
        }
        T max = this.get(0);
        for (int i = 1; i <this.size() ; i++) {
            if (max.compareTo(this.get(i))<0){
                max=this.get(i);
            }
        }
        return max;
    }

    public T min(){
        if (this.size()==0){
            return null;
        }
        T min = this.get(0);
        for (int i = 1; i <this.size() ; i++) {
            if (min.compareTo(this.get(i))>0){
                min=this.get(i);
            }
        }
        return min;
    }
}
