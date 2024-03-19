package barracks_wars_return_of_the_dependencies;


import barracks_wars_return_of_the_dependencies.core.Engine;
import barracks_wars_return_of_the_dependencies.core.commands.CommandInterpreterImpl;
import barracks_wars_return_of_the_dependencies.core.factories.UnitFactoryImpl;
import barracks_wars_return_of_the_dependencies.data.UnitRepository;
import barracks_wars_return_of_the_dependencies.interfaces.CommandInterpreter;
import barracks_wars_return_of_the_dependencies.interfaces.Repository;
import barracks_wars_return_of_the_dependencies.interfaces.UnitFactory;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository ();
        UnitFactory unitFactory = new UnitFactoryImpl ();
        CommandInterpreter interpreter = new CommandInterpreterImpl ( repository,unitFactory );

        Runnable engine = new Engine (interpreter);
        engine.run();
    }
}
