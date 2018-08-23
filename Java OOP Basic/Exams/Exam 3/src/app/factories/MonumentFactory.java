package app.factories;

import app.entities.Monument;
import app.entities.monuments.AirMonument;
import app.entities.monuments.EarthMonument;
import app.entities.monuments.FireMonument;
import app.entities.monuments.WaterMonument;

public final class MonumentFactory {
    public static final Monument generateMonument(String[] args){
        String type = args[0];
        String name = args[1];
        int affinity = Integer.parseInt(args[2]);
        Monument monument = null;
        switch (type){
            case "Air":
                monument = new AirMonument(name, affinity);
                break;
            case "Water":
                monument = new WaterMonument(name, affinity);
                break;
            case "Fire":
                monument=new FireMonument(name,affinity);
                break;
            case "Earth":
                monument=new EarthMonument(name,affinity);
                break;
        }
        return monument;
    }
}
