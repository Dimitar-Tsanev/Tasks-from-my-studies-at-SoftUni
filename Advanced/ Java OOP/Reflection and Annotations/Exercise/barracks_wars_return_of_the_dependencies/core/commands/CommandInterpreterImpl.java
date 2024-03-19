package barracks_wars_return_of_the_dependencies.core.commands;

import barracks_wars_return_of_the_dependencies.interfaces.CommandInterpreter;
import barracks_wars_return_of_the_dependencies.interfaces.Executable;
import barracks_wars_return_of_the_dependencies.interfaces.Repository;
import barracks_wars_return_of_the_dependencies.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

public class CommandInterpreterImpl implements CommandInterpreter {
    private static final String COMMAND_PACKAGE_NAME = "barracks_wars_return_of_the_dependencies.core.commands.";
    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreterImpl ( Repository repository, UnitFactory unitFactory ) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }
    @Override
    public Executable interpretCommand ( String[] data ) throws ClassNotFoundException,
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException {

        String classFullName = COMMAND_PACKAGE_NAME +
                data[0].toUpperCase ().charAt ( 0 ) +
                data[0].substring ( 1 );

        Class<?> clazz = Class.forName (classFullName);

        Constructor<?> constructor = clazz.getDeclaredConstructor ( String[].class);
        constructor.setAccessible ( true );

        Command command = (Command) constructor.newInstance ( (Object) data );

        List<Field> annotatedFields = Arrays.stream( clazz.getDeclaredFields () )
                .filter ( f -> f.isAnnotationPresent ( Inject.class ) )
                .collect( Collectors.toList());

        if (!annotatedFields.isEmpty ()){
            injectAnnotatedFields ( annotatedFields,command );
        }

        return command;
    }
    private void injectAnnotatedFields ( List<Field> annotatedFields, Command command ) throws IllegalAccessException {
        Map <Class<?>, Field> fieldsMap = new HashMap<> ();

        Arrays.stream( this.getClass ().getDeclaredFields () ).forEach (f-> fieldsMap.putIfAbsent ( f.getType (),f ) );

        for ( Field f : annotatedFields ) {
            if ( fieldsMap.containsKey ( f.getType ( ) ) ) {
                f.setAccessible ( true );
                f.set ( command, fieldsMap.get ( f.getType () ).get ( this ) );
            }
        }
    }
}
