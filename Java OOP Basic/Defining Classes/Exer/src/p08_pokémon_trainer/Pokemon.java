package p08_pokémon_trainer;

public class Pokemon {
    private String name;
    private String element;
    private long health;

    public Pokemon() {
    }

    public Pokemon(String name, String element, long health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public String getElement() {
        return element;
    }

    public long getHealth() {
        return this.health;
    }

    public void decreseHealth(){
        this.health-=10;
    }


}
