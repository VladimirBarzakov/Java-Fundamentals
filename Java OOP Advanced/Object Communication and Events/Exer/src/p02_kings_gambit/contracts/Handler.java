package p02_kings_gambit.contracts;

public interface Handler {
    void handle(String message);
    void setSuccessor(Handler handler);
}
