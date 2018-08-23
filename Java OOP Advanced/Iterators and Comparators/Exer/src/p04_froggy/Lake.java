package p04_froggy;

import java.util.*;
import java.util.function.Consumer;

public class Lake<T> implements Iterable<T> {
    private List<T> list;

    public Lake(T... args) {
        this.list=Arrays.asList(args);
    }

    @Override
    public Iterator iterator() {
        return new Frog();
    }

    private final class Frog implements Iterator<T>{
        private int counter = 0;
        private boolean endOfSteps = false;
        @Override
        public boolean hasNext() {
            if (this.counter<list.size()){
                return true;
            }
            this.counter=1;
            if (this.counter>=list.size()){
                return false;
            }
            if (!this.endOfSteps){
                this.endOfSteps=true;
                return true;
            }
            return false;
        }

        public boolean hasNextNonStep() {
           return this.counter<list.size();
        }

        @Override
        public T next() {
            this.counter+=2;
            return list.get(this.counter-2);
        }

        public T nextNonStep() {
            this.counter+=2;
            return list.get(this.counter-2);
        }

        @Override
        public void forEachRemaining(Consumer<? super T> action) {
            Objects.requireNonNull(action);
            while (hasNext()){
                if (!this.endOfSteps){
                    action.accept(next());
                } else{
                    action.accept(nextNonStep());
                }

            }
        }
    }
}
