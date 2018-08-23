package p07_1984.contracts;

public interface Subject {
    void addObserver(Observer observer);
    void updateStats(String field, String newValue);
}
