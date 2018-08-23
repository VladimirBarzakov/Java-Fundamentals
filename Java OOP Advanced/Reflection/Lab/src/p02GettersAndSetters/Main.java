package p02GettersAndSetters;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Class<Reflection> aClass = Reflection.class;
        Method[] methods = aClass.getDeclaredMethods();
        List<Method> getters = new ArrayList<>();
        for (Method method:methods) {
            if (method.getName().startsWith("get")){
                if (method.getParameterTypes().length==0){
                    getters.add(method);
                }
            }
        }
        getters.sort(Comparator.comparing(Method::getName));
        for (Method method:getters) {
            System.out.printf("%s will return %s%n",method.getName(), method.getReturnType());
        }
        List<Method> setters = new ArrayList<>();
        for (Method method:methods) {
            if (method.getName().startsWith("set")){
                if (method.getParameterTypes().length==1){
                    setters.add(method);
                }
            }
        }
        setters.sort(Comparator.comparing(Method::getName));
        for (Method method:setters) {
            System.out.printf("%s and will set field of %s%n",method.getName(),
                    Arrays.toString(method.getParameterTypes()).replaceAll("[\\[\\]]",""));
        }

    }
}
