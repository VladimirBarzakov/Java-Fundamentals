package pr0304Barracks.models.command;

import pr0304Barracks.contracts.Executable;

public abstract class Command implements Executable {
    private String[] data;


    protected Command(String[] data) {
        this.data = data;
    }

    protected String[] getData() {
        return this.data;
    }

}
