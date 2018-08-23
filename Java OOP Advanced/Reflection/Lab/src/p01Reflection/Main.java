package p01Reflection;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Reflection> aClass = Reflection.class;
        System.out.println(aClass);
        System.out.println(aClass.getSuperclass());
        Class[] interfaces = aClass.getInterfaces();
        for (Class aInterface:interfaces) {
            System.out.println(aInterface);
        }
        Reflection ref = aClass.getDeclaredConstructor().newInstance();
        System.out.println(ref);
    }
}
