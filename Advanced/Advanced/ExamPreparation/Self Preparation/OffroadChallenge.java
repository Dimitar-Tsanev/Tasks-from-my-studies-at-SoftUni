import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OffroadChallenge {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        Deque<Integer> fuelDeque = fillDeque ( scanner );

        Queue<Integer> consumptionQueue = fillQueue ( scanner );

        Queue<Integer> fuelNeededQueue = fillQueue ( scanner );

        int allAltitudes = fuelNeededQueue.size ();

        int altitudesReached = 0;

        while (!fuelDeque.isEmpty () && !fuelNeededQueue.isEmpty () && !consumptionQueue.isEmpty ()){
            int fuelNeeded = fuelNeededQueue.poll ();

            int consumption = consumptionQueue.poll ();
            int fuelTank = fuelDeque.pop ();

            int fuel = fuelTank - consumption;

            if (fuelNeeded <= fuel){
                altitudesReached++;
                System.out.println ( "John has reached: Altitude " + altitudesReached );

            }else {
                System.out.println ( "John did not reach: Altitude " + (altitudesReached + 1 ));
                break;

            }
        }
        if (altitudesReached == allAltitudes ){
            System.out.println ("John has reached all the altitudes and managed to reach the top!" );
            return;

        }
        System.out.println ("John failed to reach the top." );

        if(altitudesReached == 0){
            System.out.println ( "John didn't reach any altitude." );

        }else {
            System.out.print ( "Reached altitudes: ");
            IntStream.range ( 1, altitudesReached ).forEach ( a -> System.out.printf ( "Altitude %d, ", a ) );
            System.out.println ( "Altitude " + altitudesReached );
        }
    }
    private static Deque<Integer> fillDeque ( Scanner scanner ) {
        Deque <Integer> wormsDeque = new ArrayDeque <> (  );

        Arrays.stream( scanner.nextLine ().split ( "\\s+" ) )
                .map ( Integer::parseInt )
                .forEach ( wormsDeque::push );

        return  wormsDeque;
    }
    private static Queue<Integer> fillQueue (Scanner scanner){
       return Arrays.stream ( scanner.nextLine ().split ( "\\s+" ) )
                .map ( Integer::parseInt )
                .collect ( Collectors.toCollection ( ArrayDeque::new ) );
    }
}
