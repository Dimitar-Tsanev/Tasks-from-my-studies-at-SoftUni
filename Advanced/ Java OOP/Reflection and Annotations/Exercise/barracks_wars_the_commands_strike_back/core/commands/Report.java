package barracks_wars_the_commands_strike_back.core.commands;

import barracks_wars_the_commands_strike_back.interfaces.Repository;
import barracks_wars_the_commands_strike_back.interfaces.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class Report extends Command{
    public Report ( String[] data, Repository repository, UnitFactory unitFactory ) {
        super ( data, repository, unitFactory );
    }
    @Override
    public String execute () throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        return super.getRepository ().getStatistics();
    }
}
