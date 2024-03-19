package barracks_wars_return_of_the_dependencies.interfaces;

import java.lang.reflect.InvocationTargetException;

public interface UnitFactory {

    Unit createUnit( String unitType) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException;
}