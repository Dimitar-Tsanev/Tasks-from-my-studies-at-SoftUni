package barracks_wars_return_of_the_dependencies.core.commands;

import barracks_wars_return_of_the_dependencies.interfaces.Repository;
import barracks_wars_return_of_the_dependencies.interfaces.Unit;
import barracks_wars_return_of_the_dependencies.interfaces.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class Add extends Command {
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;
    protected Add ( String[] data) {
        super ( data);
    }
    @Override
    public String execute () throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        String unitType = super.getData ( )[1];

        Unit unitToAdd = this.unitFactory.createUnit ( unitType );

        this.repository.addUnit ( unitToAdd );

        return unitType + " added!";
    }
}
