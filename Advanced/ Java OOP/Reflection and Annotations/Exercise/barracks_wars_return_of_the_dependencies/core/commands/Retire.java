package barracks_wars_return_of_the_dependencies.core.commands;

import barracks_wars_return_of_the_dependencies.interfaces.Repository;

import java.lang.reflect.InvocationTargetException;

public class Retire extends Command {
    @Inject
    private Repository repository;
    public Retire ( String[] data) {
        super ( data);
    }

    @Override
    public String execute () throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        String unitType = super.getData ( )[1];

        this.repository.removeUnit ( unitType );

        return unitType + " retired!";
    }
}
