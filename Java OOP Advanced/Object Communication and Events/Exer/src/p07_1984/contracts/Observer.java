package p07_1984.contracts;

public interface Observer {
    void update(String classname,
                String id,
                String fieldName,
                String fieldType,
                String oldValue,
                String newValue);
}
