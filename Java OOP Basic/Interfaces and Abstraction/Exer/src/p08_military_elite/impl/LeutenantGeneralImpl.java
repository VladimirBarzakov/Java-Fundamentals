package p08_military_elite.impl;

import p08_military_elite.interfaces.LeutenantGeneral;
import p08_military_elite.interfaces.Private;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LeutenantGeneralImpl extends PrivateImpl implements LeutenantGeneral {

    private List<Private> privates;

    public LeutenantGeneralImpl(int id, String firstName, String lastName, double salary, List<Private> privates) {
        super(id, firstName, lastName, salary);
        this.privates=privates.stream()
                .sorted((x,y)->Integer.compare(y.getId(),x.getId()))
                .collect(Collectors.toCollection(ArrayList::new));

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString()).append(System.lineSeparator());
        builder.append("Privates:");
        for (Private privateRank:this.privates) {
            builder.append(System.lineSeparator()).append("  ").append(privateRank.toString());
        }
        return builder.toString();
    }
}
