package model;


import java.util.Map;
import java.util.TreeMap;

public class Family {
    private String id;
    private Map<String, Colonist> members;

    public Family(String id) {
        this.id = id;
        this.members=new TreeMap<>();
    }

    public String getId() {

        return this.id;
    }

    protected Map<String, Colonist> getMembers() {
        return this.members;
    }
}
