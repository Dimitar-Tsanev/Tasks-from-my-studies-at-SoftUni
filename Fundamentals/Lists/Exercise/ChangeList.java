import java.util.*;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        List <Integer> numbers =
                 Arrays.stream ( scan.nextLine ().split ( " " ) )
                .map ( Integer::parseInt )
                .collect( Collectors.toList());

        String [] commands = scan.nextLine ().split ( " " );

        while (!commands [0].equals ( "end" )){

            if ( commands [0].equals ( "Delete" ) ) {
                int toRemove = Integer.parseInt ( commands [1] );
                Collection <Integer> collection = Collections.singleton ( toRemove );
                numbers.removeAll (collection);

            }else if (commands[0].equals ( "Insert" )){
                int toInsert = Integer.parseInt ( commands [1]);
                int indexOfInsertion = Integer.parseInt ( commands[2] );
                numbers.add ( indexOfInsertion,toInsert );

            }
            commands = scan.nextLine ().split ( " " );
        }
        for ( int element: numbers ) {
            System.out.print ( element + " " );
        }
    }
}
