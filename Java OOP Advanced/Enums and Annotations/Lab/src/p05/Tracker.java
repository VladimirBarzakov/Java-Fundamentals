package p05;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tracker {
    static void printMethodsByAuthor(Class<?> cl){
        Map<String, List<String>> methodByAuthor = new HashMap<>();
        Method[] methods = cl.getDeclaredMethods();

        for (Method method:methods) {
            Author annotation = method.getAnnotation(Author.class);
            if (annotation!=null){
                methodByAuthor.putIfAbsent(annotation.name(), new ArrayList<>());
                methodByAuthor.get(annotation.name()).add(method.getName()+"()");
            }
        }

        for (Map.Entry<String, List<String>> entry:methodByAuthor.entrySet()) {
            System.out.printf("%s: %s%n",
                    entry.getKey(),
                    entry.getValue().toString().replaceAll("[\\[\\]]",""));
        }
    }
}
