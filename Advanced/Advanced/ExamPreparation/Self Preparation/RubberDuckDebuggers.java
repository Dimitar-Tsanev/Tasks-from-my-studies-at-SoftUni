import java.util.*;
import java.util.stream.Collectors;

public class RubberDuckDebuggers {
    private static final Scanner scanner = new Scanner ( System.in );

    public static void main ( String[] args ) {

        Map<String, Integer> duckyGiven = new LinkedHashMap<> ( );
        duckyGiven.put ( "Darth Vader Ducky: ", 0 );
        duckyGiven.put ( "Thor Ducky: ", 0 );
        duckyGiven.put ( "Big Blue Rubber Ducky: ", 0 );
        duckyGiven.put ( "Small Yellow Rubber Ducky: ", 0 );

        Map<Integer, String> timeReward = new LinkedHashMap<> ( );
        timeReward.put ( 60, "Darth Vader Ducky: " );
        timeReward.put ( 120, "Thor Ducky: " );
        timeReward.put ( 180, "Big Blue Rubber Ducky: " );
        timeReward.put ( 240, "Small Yellow Rubber Ducky: " );


        Queue<Integer> timeTakenQueue = fillQueue ( );
        Deque<Integer> tasksStack = fillDeque ( );

        while (!tasksStack.isEmpty ( ) && !timeTakenQueue.isEmpty ( )) {
            int timeTaken = timeTakenQueue.poll ( );
            int tasks = tasksStack.pop ( );

            int total = tasks * timeTaken;
            boolean givenDuck = false;

            for ( Map.Entry<Integer, String> time : timeReward.entrySet ( ) ) {
                if ( time.getKey ( ) >= total ) {
                    duckyGiven.put ( time.getValue ( ), duckyGiven.get ( time.getValue ( ) ) + 1 );
                    givenDuck = true;
                    break;
                }
            }
            if ( !givenDuck ) {
                timeTakenQueue.offer ( timeTaken );
                tasks -= 2;
                tasksStack.push ( tasks );
            }
        }
        System.out.println ( "Congratulations, all tasks have been completed! Rubber ducks rewarded:" );
        duckyGiven.forEach ( ( k, v ) -> System.out.println ( k + v ) );

    }

    private static Deque<Integer> fillDeque () {
        Deque<Integer> wormsDeque = new ArrayDeque<> ( );

        Arrays.stream ( scanner.nextLine ( ).split ( "\\s+" ) )
                .map ( Integer::parseInt )
                .forEach ( wormsDeque::push );

        return wormsDeque;
    }

    private static Queue<Integer> fillQueue () {
        return Arrays.stream ( scanner.nextLine ( ).split ( "\\s+" ) )
                .map ( Integer::parseInt )
                .collect ( Collectors.toCollection ( ArrayDeque::new ) );
    }

}
