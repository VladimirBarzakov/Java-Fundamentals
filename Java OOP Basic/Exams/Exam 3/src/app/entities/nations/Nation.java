package app.entities.nations;

import app.entities.Bender;
import app.entities.Monument;

import java.util.ArrayList;
import java.util.List;

public class Nation {

    private String name;
    private List<Bender> benders;
    private List<Monument> monuments;

    public Nation(String name) {
        this.name = name;
        this.benders=new ArrayList<>();
        this.monuments=new ArrayList<>();
    }

    public void addBender(Bender bender){
        this.benders.add(bender);
    }

    public void addMonument(Monument monument){
        this.monuments.add(monument);
    }

    public double getNationTotalPower(){
        double benderSumPower = this.benders.stream().mapToDouble(Bender::getTotalPower).sum();
        double monumentModifier=this.monuments.stream()
                .mapToDouble(Monument::getMonumentPower).sum();
        return benderSumPower+(benderSumPower/100)*monumentModifier;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s Nation",this.name)).append(System.lineSeparator());
        builder.append("Benders:");
        for (Bender bender:this.benders) {
            builder.append(System.lineSeparator()).append("###").append(bender.toString());
        }
        if (this.benders.size()==0){
            builder.append(" None");
        }
        builder.append(System.lineSeparator());
        builder.append("Monuments:");
        for (Monument monument:this.monuments) {
            builder.append(System.lineSeparator()).append("###").append(monument.toString());
        }
        if (this.monuments.size()==0){
            builder.append(" None");
        }
        return builder.toString();
    }
}
