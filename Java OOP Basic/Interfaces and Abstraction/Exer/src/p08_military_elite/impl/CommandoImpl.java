package p08_military_elite.impl;

import p08_military_elite.interfaces.Commando;
import p08_military_elite.interfaces.Mission;

import java.util.List;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {

    private List<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, String corps, List<Mission> missions) {
        super(id, firstName, lastName, salary, corps);
        this.missions=missions;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString()).append(System.lineSeparator());
        builder.append("Missions:");
        for (Mission mission:this.missions) {
            builder.append(System.lineSeparator()).append("  ").append(mission.toString());
        }
        return builder.toString();
    }
}
