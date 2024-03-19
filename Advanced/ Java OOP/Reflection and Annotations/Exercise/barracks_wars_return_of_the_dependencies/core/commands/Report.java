package barracks_wars_return_of_the_dependencies.core.commands;

import barracks_wars_return_of_the_dependencies.interfaces.Repository;

import java.lang.reflect.InvocationTargetException;

public class Report extends Command {
    @Inject
    private Repository repository;
    public Report ( String[] data ) {
        super ( data );
    }
    @Override
    public String execute () throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        return this.repository.getStatistics();
    }
}
