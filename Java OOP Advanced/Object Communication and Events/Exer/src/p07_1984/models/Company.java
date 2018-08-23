package p07_1984.models;

import p07_1984.annotations.Changable;
import p07_1984.contracts.Observer;
import p07_1984.contracts.Subject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Company implements Subject {

    private String id;
    @Changable
    private String name;
    @Changable
    private int turnover;
    @Changable
    private int revenue;
    private List<Observer> observers;

    public Company() {
        this.observers = new ArrayList<>();
    }


    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void updateStats(String fieldName, String newValue) {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().equals(fieldName) &&
                    field.isAnnotationPresent(Changable.class)){
                field.setAccessible(true);
                Class type = field.getType();
                Object value = newValue;
                if (type.getSimpleName().equals("int")){
                    value = Integer.parseInt(newValue);
                }
                try {
                    Object oldValue = field.get(this);
                    field.set(this,value);
                    for (Observer observer : this.observers) {
                        observer.update(this.getClass().getSimpleName(),
                                this.id,
                                fieldName,type.getSimpleName(),
                                oldValue.toString(),newValue);
                    }
                    break;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
