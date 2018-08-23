import javax.naming.OperationNotSupportedException;
import java.util.List;

public class ListIterator<T> {
    private int index;
    private List<T> collection;

    public ListIterator(List<T> collection) throws OperationNotSupportedException {
        if (collection==null){
            throw new OperationNotSupportedException();
        }
        this.collection = collection;
        this.index=0;
    }


    public boolean hasNext() {
        return this.index<this.collection.size()-1;
    }


    public boolean move() {
        if (this.hasNext()){
            this.index++;
            return true;
        }
        return false;
    }

    public T print() throws OperationNotSupportedException {
        if (this.collection.size()==0){
            throw new OperationNotSupportedException("Invalid Operation!");
        }
        return this.collection.get(this.index);
    }
}
