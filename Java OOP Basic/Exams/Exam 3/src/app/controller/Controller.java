package app.controller;

import app.entities.Bender;
import app.entities.Monument;
import app.entities.nations.Nation;
import app.factories.BenderFactory;
import app.factories.MonumentFactory;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Controller {
    private Map<String, Nation> nations;
    private StringBuilder builder;
    private int warCounter;

    public Controller() {
        this.nations=new LinkedHashMap<String, Nation>(){{
            put("Air", new Nation("Air"));
            put("Fire", new Nation("Fire"));
            put("Water", new Nation("Water"));
            put("Earth", new Nation("Earth"));
        }};
        builder=new StringBuilder();
        this.warCounter=0;
    }

    public String executeCommand(String[] args){
        String commandType = args[0];
        String type;
        String name;

        switch (commandType){
            case "Bender":
                type = args[1];
                Bender bender=BenderFactory.generateBender(Arrays.stream(args).skip(1).toArray(String[]::new));
                if (bender==null){
                    return null;
                }
                this.nations.get(type).addBender(bender);
                return null;
            case "Monument":
                type = args[1];
                Monument monument=MonumentFactory.generateMonument(Arrays.stream(args).skip(1).toArray(String[]::new));
                if (monument==null){
                    return null;
                }
                this.nations.get(type).addMonument(monument);
                return null;
            case "Status":
                name = args[1];
                return this.nations.get(name).toString();
            case "War":
                name = args[1];
                this.commenceWar();
                this.warCounter++;
                builder.append(String.format("War %d issued by %s",this.warCounter, name))
                        .append(System.lineSeparator());
                break;
            case "Quit":
                return this.builder.toString();
        }
        return null;
    }

    private void commenceWar() {
        String winner = this.nations.entrySet().stream().min((x, y) -> Double.compare(
                y.getValue().getNationTotalPower(), x.getValue().getNationTotalPower())).get().getKey();
        for (String key:this.nations.keySet()) {
            if (!winner.equals(key)){
                this.nations.put(key, new Nation(key));
            }
        }
    }
}
