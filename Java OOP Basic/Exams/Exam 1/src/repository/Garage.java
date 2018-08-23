package repository;

import models.Car;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Garage {
    private Map<Integer, Car> parkedCars;
    private Map<Integer, Car> allCars;
    private Map<Integer, Set<Integer>> raceCarsMarkers;

    public Garage() {
        this.parkedCars=new LinkedHashMap<>();
        this.allCars=new LinkedHashMap<>();
        this.raceCarsMarkers=new LinkedHashMap<>();
    }

    public Map<Integer, Car> getParkedCars() {
        return this.parkedCars;
    }

    public Map<Integer, Car> getAllCars() {
        return this.allCars;
    }

    public Map<Integer, Set<Integer>> getRaceCarsMarkers() {
        return this.raceCarsMarkers;
    }
}
