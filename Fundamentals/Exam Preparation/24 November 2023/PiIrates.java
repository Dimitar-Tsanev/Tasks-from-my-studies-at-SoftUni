import java.util.LinkedHashMap;
import java.util.Scanner;

public class PiIrates {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        LinkedHashMap<String, Integer> townsWealth = new LinkedHashMap<> ();
        LinkedHashMap<String, Integer> townsPopulation = new LinkedHashMap<> ();

        String input = scanner.nextLine ();

        while (!input.equals ( "Sail" )){
            String[] commandArguments = input.split ( "\\|{2}" );

            String town = commandArguments[0];
            int citizens = Integer.parseInt ( commandArguments[1] );
            int gold = Integer.parseInt ( commandArguments[2] );

            if(!townsWealth.containsKey ( town )){
                townsWealth.put ( town,gold );
                townsPopulation.put ( town,citizens );

            }else {
                townsWealth.put ( town, townsWealth.get ( town ) + gold );
                townsPopulation.put ( town, townsPopulation.get ( town ) + citizens );

            }
            input = scanner.nextLine ( );

        }
        String action = scanner.nextLine ( );

        while (!action.equals ("End")){
            String[] commandArguments = action.split ( "=>" );
            String command = commandArguments[0];
            String town = commandArguments[1];

            if (command.equals ( "Plunder" )) {
                int citizens = Integer.parseInt ( commandArguments[2] );
                int gold = Integer.parseInt ( commandArguments[3] );

                townsWealth.put ( town,townsWealth.get ( town ) - gold );
                townsPopulation.put ( town, townsPopulation.get ( town ) - citizens );

                System.out.printf ( "%s plundered! %d gold stolen, %d citizens killed.%n",town,gold,citizens );

                if (townsPopulation.get ( town ) <= 0 || townsWealth.get ( town ) <= 0){
                    townsWealth.remove ( town );
                    townsPopulation.remove ( town );

                    System.out.println ( town + " has been wiped off the map!" );
                }

            } else if ( command.equals ( "Prosper" ) ) {
                int gold =  Integer.parseInt ( commandArguments[2] );

                if (gold >= 0 ){
                    townsWealth.put ( town,townsWealth.get ( town ) + gold );

                    System.out.printf ( "%d gold added to the city treasury. %s now has %d gold.%n",
                            gold,
                            town,
                            townsWealth.get ( town ) );

                }else{
                    System.out.println ( "Gold added cannot be a negative number!"  );

                }
            }
            action = scanner.nextLine ();

        }
        if(townsWealth.isEmpty ()){
            System.out.println ( "Ahoy, Captain! All targets have been plundered and destroyed!" );

        }else{
            System.out.printf ( "Ahoy, Captain! There are %d wealthy settlements to go to:%n",townsWealth.size () );
            townsPopulation.forEach ( (k,v) -> System.out.printf ( "%s -> Population: %d citizens, Gold: %d kg%n",k,v,townsWealth.get ( k ) ) );

        }
    }
}
