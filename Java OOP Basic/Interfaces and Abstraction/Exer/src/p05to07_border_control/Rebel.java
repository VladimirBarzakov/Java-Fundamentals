package p05to07_border_control;

public class Rebel extends Minion implements Buyer {
    private int age;
    private String group;
    private int food;

    public Rebel(String name, int age, String group) {
        super(name);
        this.age=age;
        this.group=group;
        this.food=0;
    }

    @Override
    public int getFood() {
        return this.food;
    }

    @Override
    public void buyFood() {
        this.food+=5;
    }
}
