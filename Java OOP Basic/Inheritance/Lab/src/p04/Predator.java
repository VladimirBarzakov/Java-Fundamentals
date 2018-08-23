package p04;

public class Predator extends Animal{

    private int health=0;
    public void feed(Food food){
        super.foodEaten.add(food);
        this.health+=1;
    }


}
