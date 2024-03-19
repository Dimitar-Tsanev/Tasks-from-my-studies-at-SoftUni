package barracks_wars_return_of_the_dependencies.core.factories;

import barracks_wars_return_of_the_dependencies.interfaces.Unit;
import barracks_wars_return_of_the_dependencies.interfaces.UnitFactory;
import barracks_wars_return_of_the_dependencies.units.AbstractUnit;

import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME = "barracks_wars_return_of_the_dependencies.units.";

	@Override
	public Unit createUnit( String unitType) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
		Class<?> clazz = Class.forName ( UNITS_PACKAGE_NAME + unitType );
		return  (AbstractUnit) clazz.getDeclaredConstructor (  ).newInstance ( );
	}
}
