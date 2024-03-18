package barracks_wars_the_commands_strike_back.core.commands;

import barracks_wars_the_commands_strike_back.interfaces.Repository;
import barracks_wars_the_commands_strike_back.interfaces.Unit;
import barracks_wars_the_commands_strike_back.interfaces.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class Add extends Command {
    protected Add ( String[] data, Repository repository, UnitFactory unitFactory ) {
        super ( data, repository, unitFactory );
    }

    @Override
    public String execute () throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        String unitType = super.getData ( )[1];

        Unit unitToAdd = super.getUnitFactory ( ).createUnit ( unitType );

        super.getRepository ( ).addUnit ( unitToAdd );

        return unitType + " added!";
    }
}
