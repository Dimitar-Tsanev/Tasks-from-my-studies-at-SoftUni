package barracks_wars_return_of_the_dependencies.core.commands;

import java.lang.reflect.InvocationTargetException;

public class Fight extends Command {
    public Fight ( String[] data) {
        super ( data );
    }

    @Override
    public String execute () throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        return "fight";
    }
}
