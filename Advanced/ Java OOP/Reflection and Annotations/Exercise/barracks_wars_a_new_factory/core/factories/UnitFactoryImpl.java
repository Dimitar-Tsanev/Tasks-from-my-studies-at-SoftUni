package barracks_wars_a_new_factory.core.factories;

import barracks_wars_a_new_factory.interfaces.Unit;
import barracks_wars_a_new_factory.interfaces.UnitFactory;
import barracks_wars_a_new_factory.models.units.AbstractUnit;

import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME = "barracks_wars_a_new_factory.models.units.";

	@Override
	public Unit createUnit(String unitType) throws  ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		Class<?> clazz = Class.forName ( UNITS_PACKAGE_NAME + unitType );
		return  (AbstractUnit) clazz.getDeclaredConstructor (  ).newInstance ( );
	}
}
