package p07_1984.factories;

import p07_1984.contracts.Subject;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Factory {
    private static final String PATH = "p07_1984.models.";
    public Factory() {
    }

    public Subject createSubject(String... args){
        Subject subject = null;
        try {
            Class<?> clazz = Class.forName(PATH+args[0]);
            Constructor constructor = clazz.getDeclaredConstructor();
            subject = (Subject) constructor.newInstance();
            Field[] fields = subject.getClass().getDeclaredFields();
            int counter=0;
            for (int i = 1; i <args.length ; i++) {
                Field field = fields[counter++];
                field.setAccessible(true);
                Class type = field.getType();
                Object value = args[i];
                if (type.getSimpleName().equals("int")){
                    value = Integer.parseInt(args[i]);
                }
                field.set(subject,value);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return subject;
    }
}
