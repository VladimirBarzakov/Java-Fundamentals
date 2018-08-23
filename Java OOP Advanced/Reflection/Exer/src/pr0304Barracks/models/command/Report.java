package pr0304Barracks.models.command;

import pr0304Barracks.contracts.Repository;
import pr0304Barracks.models.Inject;

public class Report extends Command {
    @Inject
    private Repository repository;

    public Report(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String output = this.repository.getStatistics();
        return output;
    }
}
