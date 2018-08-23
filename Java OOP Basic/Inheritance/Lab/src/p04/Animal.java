package p04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Animal {

    public Animal() {
        this.foodEaten=new ArrayList<>();
    }

    protected List<Food> foodEaten;

    public final void eat(Food food){
        this.foodEaten.add(food);
    }

    public void eatAll(Food[] foods){
        Collections.addAll(this.foodEaten,foods);
    }
}
