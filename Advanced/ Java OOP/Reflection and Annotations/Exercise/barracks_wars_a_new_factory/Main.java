package barracks_wars_a_new_factory;

import barracks_wars_a_new_factory.interfaces.Repository;
import barracks_wars_a_new_factory.interfaces.Runnable;
import barracks_wars_a_new_factory.interfaces.UnitFactory;
import barracks_wars_a_new_factory.core.Engine;
import barracks_wars_a_new_factory.core.factories.UnitFactoryImpl;
import barracks_wars_a_new_factory.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
