import java.util.*;
import java.util.stream.Collectors;

public class TempleOfDoom {
    private static final Scanner scanner = new Scanner ( System.in );
    public static void main ( String[] args ) {

        Queue<Integer> toolsQueue = fillQueue (  );
        Deque<Integer> substancesStack = fillDeque (  );

        List<Integer> challenges = fillList();

        while (!toolsQueue.isEmpty () &&
                !substancesStack.isEmpty () &&
                !challenges.isEmpty ()){

            int tool = toolsQueue.poll ();
            int substance = substancesStack.pop ();

            int result = tool *substance;

            if (challenges.contains ( result )){
                int indexOfChallenge = challenges.indexOf ( result);
                challenges.remove ( indexOfChallenge );

            }else {
                toolsQueue.offer ( ++tool);

                substance--;

                if (substance == 0){
                    continue;
                }
                substancesStack.push ( substance );

            }
        }
        if (challenges.isEmpty ()){
            System.out.println ("Harry found an ostracon, which is dated to the 6th century BCE." );
            printInventory(toolsQueue,substancesStack);
            return;
        }
        System.out.println ( "Harry is lost in the temple. Oblivion awaits him." );
        printInventory ( toolsQueue,substancesStack );
        System.out.print ( "Challenges: ");
        System.out.println ( challenges.toString ().replaceAll ( "[\\[\\]]","" ) );

    }

    private static void printInventory ( Queue<Integer> toolsQueue, Deque<Integer> substancesStack ) {
        if(!toolsQueue.isEmpty ()){
            System.out.print ( "Tools: " );
            System.out.println ( toolsQueue.toString ().replaceAll ( "[\\[\\]]","" ));
        }
        if(!substancesStack.isEmpty ()){
            System.out.print ( "Substances: " );
            System.out.println ( substancesStack.toString ().replaceAll ( "[\\[\\]]","" ));
        }
    }

    private static List<Integer> fillList () {
       return Arrays.stream ( scanner.nextLine ().split ( "\\s+" ) )
               .map ( Integer::parseInt )
               .collect( Collectors.toList());
    }

    private static Deque<Integer> fillDeque ( ) {
        Deque <Integer> wormsDeque = new ArrayDeque <> (  );

        Arrays.stream( scanner.nextLine ().split ( "\\s+" ) )
                .map ( Integer::parseInt )
                .forEach ( wormsDeque::push );

        return  wormsDeque;
    }
    private static Queue<Integer> fillQueue (){
        return Arrays.stream ( scanner.nextLine ().split ( "\\s+" ) )
                .map ( Integer::parseInt )
                .collect ( Collectors.toCollection ( ArrayDeque::new ) );

    }

}
