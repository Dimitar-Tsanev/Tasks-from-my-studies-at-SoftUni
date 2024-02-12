import java.util.*;
import java.util.stream.Collectors;

public class ClimbThePeaks {
    private static final Scanner scanner = new Scanner ( System.in );

    public static void main ( String[] args ) {

        Map<Integer, String> neededEnergyToClimb = new LinkedHashMap<> ( );
        neededEnergyToClimb.put ( 80, "Vihren" );
        neededEnergyToClimb.put ( 90, "Kutelo" );
        neededEnergyToClimb.put ( 100, "Banski Suhodol" );
        neededEnergyToClimb.put ( 60, "Polezhan" );
        neededEnergyToClimb.put ( 70, "Kamenitza" );

        Queue<String> claimedPeeks = new ArrayDeque<> ( );

        Deque<Integer> foodStack = fillDeque ( );
        Queue<Integer> staminaQueue = fillQueue ( );

        int counter = 0;

        while (!neededEnergyToClimb.isEmpty ( )) {
            Map.Entry<Integer, String> entry = neededEnergyToClimb.entrySet ( )
                    .stream ( )
                    .findFirst ( )
                    .orElse ( null );

            counter++;

            if ( counter > 7 ) {
                break;

            }
            int staminaForTheDay = !staminaQueue.isEmpty ( ) ? staminaQueue.poll ( ) : 0;
            int foodForTheDay = !foodStack.isEmpty ( ) ? foodStack.pop ( ) : 0;

            int energyForTheDay = staminaForTheDay + foodForTheDay;

            if ( entry.getKey ( ) <= energyForTheDay ) {
                claimedPeeks.offer ( entry.getValue ( ) );
                neededEnergyToClimb.remove ( entry.getKey ( ) );

            }

        }
        String win = "Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK";
        String lose = "Alex failed! He has to organize his journey better next time -> @PIRINWINS";

        System.out.println ( neededEnergyToClimb.isEmpty ( ) ? win : lose );

        if (!claimedPeeks.isEmpty ()){
            System.out.println ( "Conquered peaks:" );

            claimedPeeks.forEach ( System.out::println );
        }
    }

    private static Deque<Integer> fillDeque () {
        Deque<Integer> wormsDeque = new ArrayDeque<> ( );

        Arrays.stream ( scanner.nextLine ( ).split ( ",\\s+" ) )
                .map ( Integer::parseInt )
                .forEach ( wormsDeque::push );

        return wormsDeque;
    }

    private static Queue<Integer> fillQueue () {
        return Arrays.stream ( scanner.nextLine ( ).split ( ",\\s+" ) )
                .map ( Integer::parseInt )
                .collect ( Collectors.toCollection ( ArrayDeque::new ) );
    }

}
