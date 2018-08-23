package pr0304Barracks.models.command;

import jdk.jshell.spi.ExecutionControl;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.models.Inject;

public class Retire extends Command {
    @Inject
    private Repository repository;

    public Retire(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitType = super.getData()[1];
        try {
            this.repository.removeUnit(unitType);
        } catch (ExecutionControl.NotImplementedException e) {
            return e.getMessage();
        }
        return String.format("%s retired!",unitType);
    }
}
