package p04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private String name;
    private List<Person> firstTeam;
    private List<Person> secondTeam;

    public Team(String name) {
        this.name = name;
        this.firstTeam=new ArrayList<>();
        this.secondTeam=new ArrayList<>();
    }

    public void addPlayer(Person person){
        if (person.getAge()<40){
            this.firstTeam.add(person);
        } else{
            this.secondTeam.add(person);
        }
    }

    public List<Person> getFirstTeam() {
        return Collections.unmodifiableList(this.firstTeam);
    }

    public List<Person> getSecondTeam() {
        return Collections.unmodifiableList(this.secondTeam);
    }
}
