package pr0304Barracks.models.command;

public class Fight extends Command{
    public Fight(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return "fight";
    }
}
