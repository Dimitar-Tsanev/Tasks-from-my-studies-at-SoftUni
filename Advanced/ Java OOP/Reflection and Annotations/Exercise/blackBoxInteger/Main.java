package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main ( String[] args )
            throws NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException {

        Scanner scanner = new Scanner ( System.in );
        Class<BlackBoxInt> clazz = BlackBoxInt.class;

        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor (  int.class );

        constructor.setAccessible ( true );

        Object object = constructor.newInstance ( 0 );

        String input;

        while (!"END".equals ( input = scanner.nextLine ( ) )) {
            String command = input.split ( "_" )[0];
            int value = Integer.parseInt ( input.split ( "_" )[1] );

            Method method = clazz.getDeclaredMethod ( command,int.class );

            method.setAccessible ( true );

            method.invoke (object,value );

            Field field =  clazz.getDeclaredFields ()[1];
            field.setAccessible ( true );
            System.out.println ( field.get ( object ) );

        }

    }
}
