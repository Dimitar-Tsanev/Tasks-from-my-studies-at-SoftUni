import java.util.*;

public class PlantDiscovery {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        int plantsNumber = Integer.parseInt ( scanner.nextLine ( ) );

        LinkedHashMap<String, Double> plantsRarity = new LinkedHashMap<> ( );
        LinkedHashMap<String, List<Double>> plantsRatings = new LinkedHashMap<> ( );

        for ( int i = 1 ; i <= plantsNumber ; i++ ) {
            String[] plantRarity = scanner.nextLine ( ).split ( "<->" );
            String plant = plantRarity[0];
            double rarity = Double.parseDouble ( plantRarity[1] );

            plantsRarity.put (plant,rarity);
            plantsRatings.put ( plant,new ArrayList<> () );

        }
        String commandLine = scanner.nextLine ();

        while (!commandLine.equals ( "Exhibition" )){
            String command = commandLine.split ( ": " )[0];
            String plant;
            double number = 0;

            if (command.equals ( "Reset" )){
                plant = commandLine.split ( ": " )[1];

            }else {
               String information = commandLine.split ( ": " )[1];
               plant = information.split ( " - " )[0];
               number = Double.parseDouble ( information.split ( " - " )[1] );

            }

            if (!plantsRarity.containsKey ( plant )){
                System.out.println ( "error" );

                commandLine = scanner.nextLine ( );
                continue;
            }

            switch (command){
                case "Rate":
                    plantsRatings.get ( plant ).add ( number );
                    break;

                case "Update":
                    plantsRarity.put ( plant,number );
                    break;

                case "Reset":
                    plantsRatings.get ( plant ).clear ();
                    break;

            }
            commandLine = scanner.nextLine ( );

        }
        System.out.println ( "Plants for the exhibition:" );

        for ( Map.Entry<String, List<Double>> plant :plantsRatings.entrySet () ) {
            double averageRating = plant.getValue ()
                    .stream ()
                    .mapToDouble ( Double::doubleValue ).average().orElse ( 0.00 );

            System.out.printf ( "- %s; Rarity: %.0f; Rating: %.2f%n",
                    plant.getKey (), plantsRarity.get ( plant.getKey () ),averageRating );
        }

    }
}
