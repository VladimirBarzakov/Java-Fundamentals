package p01_logger.contracts;

public interface Subject {
    void register(Observer observer);
    void unregister(Observer observer);
    void notifyObservers();

}
