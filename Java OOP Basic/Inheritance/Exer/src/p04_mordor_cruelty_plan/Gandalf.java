package p04_mordor_cruelty_plan;

import java.util.HashMap;
import java.util.Map;

public class Gandalf {

    private final Map<String, Integer> HAPPINESS_PER_KNOWN_FOOD = new HashMap<String, Integer>(){{
        put("cram",2);
        put("lembas",3);
        put("apple",1);
        put("melon",1);
        put("honeycake",5);
        put("mushrooms",-10);
    }};

    private long happiness;

    public Gandalf() {
        this.happiness = 0;
    }

    private final void eat(String food){
        food=food.toLowerCase();
        if (HAPPINESS_PER_KNOWN_FOOD.containsKey(food)){
            this.happiness+=HAPPINESS_PER_KNOWN_FOOD.get(food);
        } else{
            this.happiness+=-1;
        }
    }

    public final void eatAll(String[] food){
        for (String singleFood:food) {
            this.eat(singleFood);
        }
    }

    public final long getHappiness() {
        return this.happiness;
    }

    public final String getMood(){
        if (this.happiness<-5){
            return "Angry";
        } else if(this.happiness<0){
            return "Sad";
        } else if(this.happiness<15){
            return "Happy";
        } else{
            return "JavaScript";
        }
    }

}
