package barracks_wars_a_new_factory.interfaces;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}
