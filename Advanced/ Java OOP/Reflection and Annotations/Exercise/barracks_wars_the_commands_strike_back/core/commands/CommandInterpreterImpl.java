package barracks_wars_the_commands_strike_back.core.commands;

import barracks_wars_the_commands_strike_back.interfaces.CommandInterpreter;
import barracks_wars_the_commands_strike_back.interfaces.Executable;
import barracks_wars_the_commands_strike_back.interfaces.Repository;
import barracks_wars_the_commands_strike_back.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreterImpl implements CommandInterpreter {
    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreterImpl ( Repository repository, UnitFactory unitFactory ) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    private static final String COMMAND_PACKAGE_NAME = "barracks_wars_the_commands_strike_back.core.commands.";
    @Override
    public Executable interpretCommand ( String[] data, String commandName ) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String classFullName = COMMAND_PACKAGE_NAME + data[0].toUpperCase ().charAt ( 0 ) + data[0].substring ( 1 );
        Class<?> clazz = Class.forName (classFullName);

        Constructor<?> constructor = clazz.getDeclaredConstructor (String[].class,Repository.class, UnitFactory.class  );
        constructor.setAccessible ( true );

        return (Command) constructor.newInstance ( data, this.repository, this.unitFactory );
    }
}
