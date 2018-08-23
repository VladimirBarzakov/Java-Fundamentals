package pr0304Barracks.core.factories;

import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.UnitFactory;
import pr0304Barracks.models.Inject;
import pr0304Barracks.models.command.Command;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandFactoryImpl {
    private static final String COMMANDS_PACKAGE_NAME = "pr0304Barracks.models.command.";

    public Command createCommand(String type, String[] data, Repository repository, UnitFactory unitFactory){
        Command command = null;
        try {
            Class clazz = Class.forName(COMMANDS_PACKAGE_NAME+type.substring(0,1).toUpperCase()+type.substring(1));
            Constructor constructor = clazz.getConstructor(String[].class);
            command = (Command) constructor.newInstance((Object) data);
            Field[] fields = clazz.getDeclaredFields();
            for (Field field:fields) {
                if (field.isAnnotationPresent(Inject.class)){
                    field.setAccessible(true);
                    switch (field.getName()){
                        case "repository":
                            field.set(command,repository);
                            break;
                        case "unitFactory":
                            field.set(command,unitFactory);
                            break;
                    }
                    field.setAccessible(false);
                }
            }

        } catch (ClassNotFoundException |
                InvocationTargetException |
                InstantiationException |
                IllegalAccessException |
                NoSuchMethodException e) {
            e.printStackTrace();
        }
        return command;
    }
}
