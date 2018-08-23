package app.interfaces.gameModels;

import app.exceptions.InvalidUnitException;

import java.util.List;

public interface ActiveRepository<T> {
    void save(T element) throws InvalidUnitException;
    void remove(T element) throws InvalidUnitException;
    List<T> findAll();
    T getEntity(String key) throws InvalidUnitException;
}
