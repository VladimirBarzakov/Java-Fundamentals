package p05;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {
    Random rnd;

    public RandomArrayList() {
        this.rnd = new Random();
    }

    public Object getRandomElement(){
        int index = rnd.nextInt(this.size());
        Object object = this.get(index);
        this.remove(index);
        return object;
    }
}
