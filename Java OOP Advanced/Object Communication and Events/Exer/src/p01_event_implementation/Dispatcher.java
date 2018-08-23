package p01_event_implementation;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {
    private String name;
    private List<NameChangeListener> nameChangeListenerList;

    public Dispatcher() {
        this.nameChangeListenerList = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
        NameChange event = new NameChange(name);
        this.fireNameChangeEvent(event);
    }

    public void addNameChangeListener(NameChangeListener nameChangeListener){
        this.nameChangeListenerList.add(nameChangeListener);
    }

    public void removeNameChangeListener(NameChangeListener nameChangeListener){
        this.nameChangeListenerList.remove(nameChangeListener);
    }

    public void fireNameChangeEvent(NameChange nameChange){
        for (NameChangeListener nameChangeListener : nameChangeListenerList) {
            nameChangeListener.handleChangedName(nameChange);
        }
    }

}
