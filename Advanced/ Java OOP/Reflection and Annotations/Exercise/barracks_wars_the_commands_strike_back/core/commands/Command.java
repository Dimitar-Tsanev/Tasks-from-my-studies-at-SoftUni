package barracks_wars_the_commands_strike_back.core.commands;

import barracks_wars_the_commands_strike_back.interfaces.Executable;
import barracks_wars_the_commands_strike_back.interfaces.Repository;
import barracks_wars_the_commands_strike_back.interfaces.UnitFactory;

public abstract class Command implements Executable {
    private String[] data;
    private Repository repository;
    private UnitFactory unitFactory;

    protected Command ( String[] data, Repository repository, UnitFactory unitFactory ) {
        this.data = data;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    protected String[] getData () {
        return data;
    }

    protected Repository getRepository () {
        return repository;
    }

    protected UnitFactory getUnitFactory () {
        return unitFactory;
    }
}
