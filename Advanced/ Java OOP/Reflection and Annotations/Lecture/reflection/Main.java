package reflection;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main ( String[] args ) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<Reflection> clasS = Reflection.class;

        Class superClass = clasS.getSuperclass ();

        Class[] interfaces = clasS.getInterfaces ();

        Object object = clasS.getDeclaredConstructor (  ).newInstance (  );

        System.out.println (clasS.toString ()
                .replace ( clasS.getPackageName (), "" )
                .replace ( ".", "" ) );

        System.out.println (superClass );

        for ( Class anInterface : interfaces ) {
            System.out.println ( anInterface );
        }

        System.out.println ( object );

    }
}
