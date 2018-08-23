package app.interfaces.gameModels;

import java.util.List;

public interface InactiveRepository<T> {
    void save(T element);
    List<T> getAll();
}
