package p02;

public class Message {
    private Importance importance;
    private String message;

    public Message(String importance, String message) {
        this.importance = Importance.valueOf(Importance.class, importance);
        this.message = message;
    }

    public Importance getImportance() {
        return this.importance;
    }

    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        return String.format("%s: %s",this.importance, this.message);
    }
}
