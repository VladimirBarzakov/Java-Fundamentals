package p02;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Logger {
    List<Message> log;
    Importance importanceFilter;

    public Logger(String importanceFilter) {
        this.importanceFilter=Importance.valueOf(Importance.class, importanceFilter);
        this.log=new ArrayList<>();
    }

    public void addMessage(Message message){
        this.log.add(message);
    }

    public Iterable<Message> getMessages(){
        return this.log.stream().filter(x->x.getImportance()
                .compareTo(this.importanceFilter)>=0).collect(Collectors.toList());
    }


}
