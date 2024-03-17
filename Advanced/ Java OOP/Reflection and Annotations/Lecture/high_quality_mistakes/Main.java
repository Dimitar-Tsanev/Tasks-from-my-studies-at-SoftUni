package high_quality_mistakes;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main ( String[] args ) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<Reflection> clazz = Reflection.class;
        Field[] fields = Arrays.stream( clazz.getDeclaredFields () ).
                sorted (Comparator.comparing ( Field::getName ))
                .toArray ( Field[]::new );

        Method[] methods =  Arrays.stream ( clazz.getDeclaredMethods () )
                .sorted ( Comparator.comparing ( Method::getName ) )
                .toArray ( Method[]::new );


        for ( Field field: fields ){
           int modifier = field.getModifiers ();
           if (!Modifier.isPrivate ( modifier )){
               System.out.printf ( "%s must be private!%n", field.getName () );
           }
        }
        for ( Method method:methods ){
            int modifier = method.getModifiers ();
            if (method.getName ().startsWith ( "get" )) {
                if ( !Modifier.isPublic ( modifier ) ) {
                    System.out.printf ( "%s have to be public!%n", method.getName ( ) );
                }
            }else if (method.getName ().startsWith ( "set" )){
                if ( !Modifier.isPrivate ( modifier ) ) {
                    System.out.printf ( "%s have to be private!%n", method.getName ( ) );
                }
            }
        }
    }
}
