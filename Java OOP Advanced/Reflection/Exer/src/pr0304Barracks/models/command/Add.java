package pr0304Barracks.models.command;

import jdk.jshell.spi.ExecutionControl;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.Unit;
import pr0304Barracks.contracts.UnitFactory;
import pr0304Barracks.models.Inject;

public class Add extends Command {
    @Inject
    private UnitFactory unitFactory;
    @Inject
    private Repository repository;

    public Add(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitType = super.getData()[1];
        Unit unitToAdd = null;
        try {
            unitToAdd = this.unitFactory.createUnit(unitType);
        } catch (ExecutionControl.NotImplementedException e) {
            e.printStackTrace();
        }
        this.repository.addUnit(unitToAdd);
        String output = unitType + " added!";
        return output;
    }
}
