import javax.naming.OperationNotSupportedException;
import java.util.Arrays;

public class Database {
    private Integer[] elements;
    int cursor;

    public Database() {
        this.elements = new Integer[16];
        this.cursor=0;
    }

    public void add(Integer element) throws OperationNotSupportedException {
        if (element==null || this.cursor==16){
            throw new OperationNotSupportedException();
        }
        this.elements[this.cursor++]=element;
    }

    public Integer remove() throws OperationNotSupportedException {
        if (this.cursor==0){
            throw new OperationNotSupportedException();
        }
        return this.elements[--this.cursor];
    }

    public Integer[] fetch(){
        return Arrays.copyOfRange(this.elements,0,this.cursor );
    }
}
