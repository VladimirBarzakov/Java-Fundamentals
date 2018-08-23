import java.util.Collections;
import java.util.List;

public final class Bubble {
    public static <T extends Comparable<? super T>> void sort(List<T> list){
        if (list==null){
            throw new IllegalArgumentException();
        }
        if (list.size()<=1){
            return;
        }
        boolean isSorted = false;
        while (!isSorted){
            isSorted=true;
            for (int i = 0; i < list.size()-1; i++) {
                if (list.get(i).compareTo(list.get(i+1))>0){
                    isSorted=false;
                    T temp = list.get(i);
                    list.set(i,list.get(i+1));
                    list.set(i+1,temp);
                }
            }
        }
    }
}
