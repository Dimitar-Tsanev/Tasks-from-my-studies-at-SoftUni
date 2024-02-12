import java.util.*;
import java.util.stream.Collectors;

public class EnergyDrinks {
    private static final Scanner scanner = new Scanner ( System.in );
    private static final int MAXIMUM_CAFFEINE = 300;
    public static void main ( String[] args ) {

        Deque<Integer> caffeineStack = fillDeque ( );
        Queue<Integer> drinksQueue = fillQueue ();

        int currentCaffeine = 0;

        while (!drinksQueue.isEmpty () && !caffeineStack.isEmpty ()){
            int drink = drinksQueue.poll ();
            int caffeine = caffeineStack.pop ();

            int intake = drink * caffeine;

            if( intake + currentCaffeine <= MAXIMUM_CAFFEINE){
                currentCaffeine += intake;

            }else{
                currentCaffeine -= 30;
                currentCaffeine = Math.max ( currentCaffeine,0);

                drinksQueue.offer ( drink );

            }
        }
        String drinkAll = "At least Stamat wasn't exceeding the maximum caffeine.";

        String someDrinksLeft = String.format ( "Drinks left: %s",
                drinksQueue.toString ().replaceAll ( "[\\[\\]]","" ));

        System.out.println ( drinksQueue.isEmpty ()? drinkAll : someDrinksLeft);

        System.out.printf ( "Stamat is going to sleep with %d mg caffeine.%n",currentCaffeine );

    }
    private static Deque<Integer> fillDeque () {
        Deque <Integer> wormsDeque = new ArrayDeque <> (  );

        Arrays.stream( scanner.nextLine ().split ( ",\\s+" ) )
                .map ( Integer::parseInt )
                .forEach ( wormsDeque::push );

        return  wormsDeque;
    }
    private static Queue<Integer> fillQueue (){
        return Arrays.stream ( scanner.nextLine ().trim ().split ( ",\\s+" ) )
                .map ( Integer::parseInt )
                .collect ( Collectors.toCollection ( ArrayDeque::new ) );
    }

}
