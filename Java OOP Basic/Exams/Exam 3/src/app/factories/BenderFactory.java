package app.factories;

import app.entities.Bender;
import app.entities.benders.AirBender;
import app.entities.benders.EarthBender;
import app.entities.benders.FireBender;
import app.entities.benders.WaterBender;

public final class BenderFactory {
    public static Bender generateBender(String[] args){
        String type = args[0];
        String name = args[1];
        int power = Integer.parseInt(args[2]);
        double secondaryParam = Double.parseDouble(args[3]);
        Bender bender = null;
        switch (type){
            case "Air":
                bender = new AirBender(name, power, secondaryParam);
                break;
            case "Water":
                bender = new WaterBender(name, power, secondaryParam);
                break;
            case "Fire":
                bender = new FireBender(name, power, secondaryParam);
                break;
            case "Earth":
                bender = new EarthBender(name, power, secondaryParam);
                break;
        }
        return bender;
    }
}
