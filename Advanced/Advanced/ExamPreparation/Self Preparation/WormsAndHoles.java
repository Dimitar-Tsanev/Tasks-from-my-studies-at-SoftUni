import java.util.*;
import java.util.stream.Collectors;

public class WormsAndHoles {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        Deque<Integer> wormsSizeDeque = fillDeque(scanner);

        Queue<Integer> holesSizeQueue = Arrays.stream ( scanner.nextLine ().split ( "\\s+" ) )
                .map ( Integer::parseInt )
                .collect ( Collectors.toCollection ( ArrayDeque::new ) );

        int matches = 0;
        boolean deadWorms = false;

        while (!holesSizeQueue.isEmpty () && !wormsSizeDeque.isEmpty ()){
            if (wormsSizeDeque.peek () <= 0){
                wormsSizeDeque.pop ();
                deadWorms = true;
                continue;
            }

            int hole = holesSizeQueue.poll ();
            int worm = wormsSizeDeque.pop ();

            if (hole == worm){
                matches++;

            }else{
                worm -= 3;
                wormsSizeDeque.push ( worm );

            }
        }
        String win = String.format ( "Matches: %d",matches );
        String lose = "There are no matches.";

        System.out.println ( matches > 0 ? win : lose );

        if (wormsSizeDeque.isEmpty ()){
            win = "Every worm found a suitable hole!";
            lose = "Worms left: none";

            System.out.println ( deadWorms ? lose : win );

        }else {
            System.out.print ( "Worms left: " );
            printWorms(wormsSizeDeque);

        }
        System.out.print ("Holes left: ");

        System.out.println ( holesSizeQueue.isEmpty () ?
                "none" :
                String.join ( ", ",
                        holesSizeQueue.toString ().replaceAll ( "[\\[\\]]","" )) );

    }

    private static void printWorms ( Deque<Integer> wormsDeque ) {
        Deque <Integer> wormsSizeDeque = new ArrayDeque<> (  );

        while (!wormsDeque.isEmpty ()){
            wormsSizeDeque.push ( wormsDeque.pop () );

        }
        while ( !wormsSizeDeque.isEmpty ()){

            if ( 1 != wormsSizeDeque.size () ) {
                System.out.print ( wormsSizeDeque.pop ( ) + ", ");

            }else {
                System.out.println ( wormsSizeDeque.pop () );
            }
        }
    }

    private static Deque<Integer> fillDeque ( Scanner scanner ) {
        Deque <Integer> wormsDeque = new ArrayDeque <> (  );

        Arrays.stream( scanner.nextLine ().split ( "\\s+" ) )
                .map ( Integer::parseInt )
                .forEach ( wormsDeque::push );

        return  wormsDeque;
    }
}
