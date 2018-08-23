package factories;

import contracts.Layout;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class LayoutFactory {
    private final String PATH = "models.layouts";

    public LayoutFactory() {
    }

    public Layout generateLayout(String type){
        Constructor<?> constructor = this.getConstructor(type);
        return this.generateLayoutFromConstructor(constructor);
    }

    private Constructor getConstructor(String type) {
        Constructor<?> constructor = null;
        try {
            Class<?> clazz = Class.forName(PATH+"."+type);
            constructor = clazz.getDeclaredConstructor();
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return constructor;
    }

    private Layout generateLayoutFromConstructor(Constructor<?> constructor) {
        Layout layout = null;
        try {
            layout = (Layout) constructor.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return layout;
    }
}
