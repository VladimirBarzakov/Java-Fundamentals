package p06;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class StackOfStrings {
    private List<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String item){
        this.data.add(item);
    }

    public String pop(){
        if (this.data.isEmpty()){
            throw new NoSuchElementException();
        }
        return this.data.remove(this.data.size()-1);
    }

    public boolean isEmpty(){
        return this.data.isEmpty();
    }

    public String peek(){
        if (this.data.isEmpty()){
            throw new NoSuchElementException();
        }
        return this.data.get(this.data.size()-1);
    }
}
