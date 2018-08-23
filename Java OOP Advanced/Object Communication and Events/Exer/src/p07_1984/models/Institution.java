package p07_1984.models;

import p07_1984.contracts.Observer;
import p07_1984.contracts.Subject;

import java.util.ArrayList;
import java.util.List;

public class Institution implements Observer {

    private String id;
    private String name;
    private String[] fieldNames;
    private List<Subject> subjects;
    private List<String> messages;

    public Institution(String id, String name, String... fieldNames) {
        this.id = id;
        this.name = name;
        this.fieldNames = fieldNames;
        this.subjects=new ArrayList<>();
        this.messages=new ArrayList<>();
    }

    @Override
    public void update(String classname, String id, String fieldName, String fieldType, String oldValue, String newValue) {
        for (String watchedFieldName : this.fieldNames) {
            if (fieldName.equals(watchedFieldName)){
                String message = String.format("--%s(ID:%s) changed %s(%s) from %s to %s",classname,id,fieldName,fieldType,oldValue,newValue);
                this.messages.add(message);
                break;
            }
        }

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s: %d changes registered",this.name, this.messages.size()));
        for (String message : this.messages) {
            builder.append(System.lineSeparator()).append(message);
        }
        return builder.toString();
    }
}
