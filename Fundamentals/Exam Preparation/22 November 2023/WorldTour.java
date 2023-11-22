import java.util.Scanner;

public class WorldTour {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        StringBuilder plannedStops = new StringBuilder ( scanner.nextLine ( ) );

        String[] command = scanner.nextLine ( ).split ( ":" );

        while (!command[0].equals ( "Travel" )) {
            switch (command[0]) {
                case "Add Stop":
                    int insertAtIndex = Integer.parseInt ( command[1] );
                    String newStop = command[2];

                    if ( insertAtIndex >= 0 && insertAtIndex < plannedStops.length ( ) ) {
                        plannedStops.insert ( insertAtIndex, newStop );

                    }

                    System.out.println ( plannedStops );
                    break;

                case "Remove Stop":
                    int removeFrom = Integer.parseInt ( command[1] );
                    int removeTo = Integer.parseInt ( command[2] );

                    if ( removeFrom <= removeTo && removeFrom >= 0 && removeFrom < plannedStops.length ( ) && removeTo < plannedStops.length ( ) ) {
                        plannedStops.delete ( removeFrom, removeTo + 1 );

                    }

                    System.out.println ( plannedStops );
                    break;

                case "Switch":
                    String replace = command[1];
                    String replacement = command[2];

                    if ( !replace.equals ( replacement ) ) {
                        String current = plannedStops.toString ( );
                        current = current.replace ( replace, replacement );
                        plannedStops.setLength ( 0 );
                        plannedStops.append ( current );

                   }

                    System.out.println ( plannedStops );
                    break;
            }

            command = scanner.nextLine ( ).split ( ":" );
        }
        System.out.println ( "Ready for world tour! Planned stops: " + plannedStops );
    }
}
