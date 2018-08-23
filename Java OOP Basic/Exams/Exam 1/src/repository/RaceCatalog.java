package repository;

import models.Race;

import java.util.LinkedHashMap;
import java.util.Map;

public class RaceCatalog {
    private Map<Integer, Race> races;

    public RaceCatalog() {
        this.races=new LinkedHashMap<>();
    }

    public Map<Integer, Race> getRaces() {
        return this.races;
    }
}