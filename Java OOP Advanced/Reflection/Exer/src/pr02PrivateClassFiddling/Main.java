package pr02PrivateClassFiddling;

import pr02PrivateClassFiddling.com.peshoslav.BlackBoxInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.*;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException,
			IllegalAccessException,
			InvocationTargetException,
			InstantiationException,
			IOException {
		String path = "pr02PrivateClassFiddling.com.peshoslav.BlackBoxInt";
		Class clazz = Class.forName(path);
		Constructor constructor = null;
		Constructor[] ctors = clazz.getDeclaredConstructors();
		for (Constructor ctor:ctors) {
			if (ctor.getParameterCount()==0){
				constructor=ctor;
				constructor.setAccessible(true);
				break;
			}
		}
		BlackBoxInt blackBoxInt = (BlackBoxInt) constructor.newInstance();
		Method[] methods = BlackBoxInt.class.getDeclaredMethods();

		Method add = null;
		Method subtract = null;
		Method multiply = null;
		Method divide = null;
		Method leftShift = null;
		Method rightShift = null;

		for (Method method:methods) {
			switch (method.getName()){
				case "add":
					add=method;
					add.setAccessible(true);
					break;
				case "subtract":
					subtract=method;
					subtract.setAccessible(true);
					break;
				case "multiply":
					multiply=method;
					multiply.setAccessible(true);
					break;
				case "divide":
					divide=method;
					divide.setAccessible(true);
					break;
				case "leftShift":
					leftShift=method;
					leftShift.setAccessible(true);
					break;
				case "rightShift":
					rightShift=method;
					rightShift.setAccessible(true);
					break;
			}
		}
		Field[] fields = BlackBoxInt.class.getDeclaredFields();
		Field field = null;
		for (Field declaredField:fields ) {
			int modifier = declaredField.getModifiers();
			if (declaredField.getType().equals(int.class) &&
					!Modifier.isFinal(modifier) && !Modifier.isStatic(modifier)){
				field=declaredField;
				field.setAccessible(true);
				break;
			}
		}

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while (true){
			line=reader.readLine();
			if ("END".equals(line)){
				break;
			}
			String[] tokens = line.split("_");
			switch (tokens[0]){
				case "add":
					add.invoke(blackBoxInt,Integer.parseInt(tokens[1]));
					break;
				case "subtract":
					subtract.invoke(blackBoxInt,Integer.parseInt(tokens[1]));
					break;
				case "multiply":
					multiply.invoke(blackBoxInt,Integer.parseInt(tokens[1]));
					break;
				case "divide":
					divide.invoke(blackBoxInt,Integer.parseInt(tokens[1]));
					break;
				case "leftShift":
					leftShift.invoke(blackBoxInt,Integer.parseInt(tokens[1]));
					break;
				case "rightShift":
					rightShift.invoke(blackBoxInt,Integer.parseInt(tokens[1]));
					break;
			}
			int result = (int) field.get(blackBoxInt);
			System.out.println(result);
		}
	}
}
