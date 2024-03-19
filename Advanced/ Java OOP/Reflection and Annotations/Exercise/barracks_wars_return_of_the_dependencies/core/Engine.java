package barracks_wars_return_of_the_dependencies.core;

import barracks_wars_return_of_the_dependencies.interfaces.CommandInterpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

     private CommandInterpreter interpreter;

    public Engine ( CommandInterpreter interpreter  ) {
        this.interpreter = interpreter;

    }

    @Override
    public void run () {
        BufferedReader reader = new BufferedReader (
                new InputStreamReader ( System.in ) );

        while (true) {

            try {
                String[] data = reader.readLine ( )
						.split ( "\\s+" );

                String result = this.interpreter
						.interpretCommand ( data )
						.execute ( );

                if ( result.equals ( "fight" ) ) {
                    break;
                }

                System.out.println ( result );

            } catch (RuntimeException e) {
                System.out.println ( e.getMessage ( ) );

            } catch (IOException
					 | ClassNotFoundException
					 | InvocationTargetException
					 | InstantiationException
					 | IllegalAccessException
					 | NoSuchMethodException e) {

                e.printStackTrace ( );
            }
        }
    }
}
