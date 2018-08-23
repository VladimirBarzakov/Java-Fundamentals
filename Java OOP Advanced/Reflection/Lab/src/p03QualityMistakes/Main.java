package p03QualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Class<Reflection> aClass = Reflection.class;
        List<String> mistakes = new ArrayList<>();
        Field[] fields = Arrays.stream(aClass.getDeclaredFields())
                .sorted(Comparator.comparing(Field::getName)).toArray(Field[]::new);
        for (Field field : fields) {
            int modifier = field.getModifiers();
            if (!Modifier.isPrivate(modifier)) {
                mistakes.add(String.format("%s must be private!", field.getName()));
            }
        }
        Method[] methods = aClass.getDeclaredMethods();
        List<Method> getters = new ArrayList<>();
        for (Method method : methods) {
            if (method.getName().startsWith("get")) {
                if (method.getParameterTypes().length == 0) {
                    getters.add(method);
                }
            }
        }
        getters.sort(Comparator.comparing(Method::getName));
        List<Method> setters = new ArrayList<>();
        for (Method method : methods) {
            if (method.getName().startsWith("set")) {
                if (method.getParameterTypes().length == 1) {
                    setters.add(method);
                }
            }
        }
        setters.sort(Comparator.comparing(Method::getName));
        for (Method method : getters) {
            int modifier = method.getModifiers();
            if (!Modifier.isPublic(modifier)) {
                mistakes.add(String.format("%s have to be public!", method.getName()));
            }
        }
        for (Method method : setters) {
            int modifier = method.getModifiers();
            if (!Modifier.isPrivate(modifier)) {
                mistakes.add(String.format("%s have to be private!", method.getName()));
            }
        }

        for (String message : mistakes) {
            System.out.println(message);
        }
        //if (mistakes.size() > 3) {
        //    System.out.println("Your code is full of bugs. You don’t understand encapsulation man");
        //}
    }
}
