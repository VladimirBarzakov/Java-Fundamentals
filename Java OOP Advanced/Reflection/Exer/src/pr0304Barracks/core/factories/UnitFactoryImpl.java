package pr0304Barracks.core.factories;

import pr0304Barracks.contracts.Unit;
import pr0304Barracks.contracts.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"pr0304Barracks.models.units.";

	@Override
	public Unit createUnit(String unitType) {
		Unit unit = null;
		try {
			Class clazz = Class.forName(UNITS_PACKAGE_NAME+unitType);
			Constructor constructor = clazz.getConstructor();
			unit = (Unit) constructor.newInstance();
		} catch (ClassNotFoundException |
				NoSuchMethodException |
				InvocationTargetException |
				InstantiationException |
				IllegalAccessException e) {
			e.printStackTrace();
		}

		return unit;
		// TODO: implement for problem 3

	}
}
