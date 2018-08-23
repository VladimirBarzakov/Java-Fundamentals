package pr01HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	private static final String FINAL_COMMAND="HARVEST";

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		Class clazz = RichSoilLand.class;
		Field[] fields = clazz.getDeclaredFields();
		Map<String, List<Field>> fieldsByAccess = new HashMap<>();
		for (Field field:fields) {
			int modifier = field.getModifiers();
			switch (modifier){
				case Modifier.PUBLIC:
					fieldsByAccess.putIfAbsent("public",new ArrayList<>());
					fieldsByAccess.get("public").add(field);
					break;
				case Modifier.PROTECTED:
					fieldsByAccess.putIfAbsent("protected",new ArrayList<>());
					fieldsByAccess.get("protected").add(field);
					break;
				case Modifier.PRIVATE:
					fieldsByAccess.putIfAbsent("private",new ArrayList<>());
					fieldsByAccess.get("private").add(field);
					break;
			}
		}
		String line;
		while (true){
			line=reader.readLine();
			if (FINAL_COMMAND.equals(line)){
				break;
			}
			switch (line){
				case "private":
					if (!fieldsByAccess.containsKey("private")){
						continue;
					}
					for (Field field:fieldsByAccess.get("private")){
						builder.append(String.format("%n%s %s %s",
								"private",
								field.getType().getSimpleName(),field.getName()));
					}
					break;
				case "protected":
					if (!fieldsByAccess.containsKey("protected")){
						continue;
					}
					for (Field field:fieldsByAccess.get("protected")){
						builder.append(String.format("%n%s %s %s",
								"protected",
								field.getType().getSimpleName(),field.getName()));
					}
					break;
				case "public":
					if (!fieldsByAccess.containsKey("public")){
						continue;
					}
					for (Field field:fieldsByAccess.get("public")){
						builder.append(String.format("%n%s %s %s",
								"public",
								field.getType().getSimpleName(),field.getName()));
					}
					break;
				case "all":
					for (Field field:fields) {
						int modifier = field.getModifiers();
						builder.append(String.format("%n%s %s %s",
								Modifier.toString(modifier),
								field.getType().getSimpleName(),field.getName()));
					}
					break;
			}
			System.out.print(builder.toString());
			builder.setLength(0);
		}

	}
}
