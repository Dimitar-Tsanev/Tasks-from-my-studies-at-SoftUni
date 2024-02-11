import java.util.*;
import java.util.stream.Collectors;

/*Task description - You gathered a few programmers and gave them a
 task and judging by the time it took them to write the code, you reward them with a type
 of rubber ducky.
You will be given two sequences of integers. The first one represents the time it takes a
programmer to complete a single task. The second one represents the number of tasks you’ve
given to your programmers.
Your task is to count how many rubber ducks of each type you’ve given to your programmers.
While you have values in the sequences, you need to start from the first value of the
programmers time's sequence and multiply them by the last value of the tasks' sequence:

•	If the calculated time is between any of the time ranges below, you give the
corresponding ducky and remove the programmer time's value and the tasks' value.

•	If the calculated time goes above the highest range, decrease the number
 of the task's value by 2. Then, move the programmer time's value to the end
 of its sequence, and continue with the next operation.

Rubber Ducky type	Time needed to earn it
Darth Vader Ducky	0 - 60
Thor Ducky	61 – 120
Big Blue Rubber Ducky	121 - 180
Small Yellow Rubber Ducky	181 - 240

Your task is considered done when the sequences are empty.

Input
•	The first line will represent each programmer’s time to complete a single task
– integers, separated by a single space.

•	The second line will represent the number of tasks that should be completed
– integers, separated by a single space.

Output
•	On the first line, you output:
o	"Congratulations, all tasks have been completed! Rubber ducks rewarded:"
•	On the next 4 lines, you output the type and number of ducks given, ordered
like in the table:
o	"Darth Vader Ducky: {count}
Thor Ducky: {count}
Big Blue Rubber Ducky: {count}
Small Yellow Rubber Ducky: {count}"

Constraints
•	All the given numbers will be valid integers in the range [1, 1000].
•	There will be no negative inputs.
•	The number of values in both sequences will always be equal.*/


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
