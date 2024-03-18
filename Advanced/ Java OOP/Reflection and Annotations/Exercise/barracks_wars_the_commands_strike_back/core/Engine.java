package barracks_wars_the_commands_strike_back.core;

import barracks_wars_the_commands_strike_back.core.commands.Command;
import barracks_wars_the_commands_strike_back.core.commands.CommandInterpreterImpl;
import barracks_wars_the_commands_strike_back.interfaces.CommandInterpreter;
import barracks_wars_the_commands_strike_back.interfaces.Repository;
import barracks_wars_the_commands_strike_back.interfaces.UnitFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

	private Repository repository;
	private UnitFactory unitFactory;

	public Engine(Repository repository, UnitFactory unitFactory) {
		this.repository = repository;
		this.unitFactory = unitFactory;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader (System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				CommandInterpreter interpreter = new CommandInterpreterImpl ( this.repository,this.unitFactory );
				Command command = (Command) interpreter.interpretCommand(data, commandName);
				String result = command.execute ();
				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException | InvocationTargetException | InstantiationException |
                     IllegalAccessException | NoSuchMethodException e) {
                throw new RuntimeException ( e );
            }
        }
	}
}
