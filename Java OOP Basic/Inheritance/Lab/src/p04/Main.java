package p04;

public class Main {
    public static void main(String[] args) {
        Predator predator = new Predator();
        Food[] foods = new Food[]{new Food(), new Food(), new Food()};
        predator.eatAll(foods);
    }
}
