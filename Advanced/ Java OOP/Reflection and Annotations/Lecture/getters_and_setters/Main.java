package getters_and_setters;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main ( String[] args )
            throws ClassNotFoundException,
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException {

        Class<Reflection> clasS = Reflection.class;

        Method[] methods = clasS.getDeclaredMethods ();
        Method[] getters = Arrays.stream ( methods )
                .filter ( m -> m.getName ( ).startsWith ( "get" ) )
                .sorted ( Comparator.comparing ( Method::getName ) )
                .toArray ( Method[]::new );

        Method[] setters = Arrays.stream ( methods )
                .filter ( m -> m.getName ( ).startsWith ( "set" ) )
                .sorted ( Comparator.comparing ( Method::getName ) )
                .toArray ( Method[]::new );

        for ( Method getter : getters ) {
            System.out.printf ( "%s will return class %s%n", getter.getName ( ), getter.getReturnType().getTypeName() );
        }
        for ( Method setter: setters  ){
            System.out.printf ( "%s and will set field of class %s%n", setter.getName (), setter.getParameterTypes()[0].getTypeName() );
        }
    }
}
