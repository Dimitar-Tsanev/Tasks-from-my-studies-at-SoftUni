package barracks_wars_return_of_the_dependencies.core.commands;

import barracks_wars_return_of_the_dependencies.interfaces.Executable;

public abstract class Command implements Executable {
    private String[] data;
    protected Command ( String[] data) {
        this.data = data;
    }
    protected String[] getData () {
        return data;
    }

}
