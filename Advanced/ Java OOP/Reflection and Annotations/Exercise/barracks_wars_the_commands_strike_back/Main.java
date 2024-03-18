package barracks_wars_the_commands_strike_back;


import barracks_wars_the_commands_strike_back.core.Engine;
import barracks_wars_the_commands_strike_back.core.factories.UnitFactoryImpl;
import barracks_wars_the_commands_strike_back.data.UnitRepository;
import barracks_wars_the_commands_strike_back.interfaces.Repository;
import barracks_wars_the_commands_strike_back.interfaces.UnitFactory;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository ();
        UnitFactory unitFactory = new UnitFactoryImpl ();

        Runnable engine = new Engine (repository, unitFactory);
        engine.run();
    }
}
