import java.util.ArrayDeque;

public class Jar<T> {
    private ArrayDeque<T> stack;

    public Jar() {
        this.stack = new ArrayDeque<>();
    }

    public void add(T element) {
        this.stack.addLast(element);
    }

    public T remove(){
        if (stack.size()==0){
            return null;
        }
        return this.stack.removeLast();
    }
}
