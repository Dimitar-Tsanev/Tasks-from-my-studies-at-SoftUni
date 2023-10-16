import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDoNotGo {
    public static void main ( String[] args ) {

        Scanner scan = new Scanner ( System.in );

        List<Integer> distances =
                Arrays.stream ( scan.nextLine ().split ( " " ) )
                .map ( Integer::parseInt )
                .collect( Collectors.toList());

        int sumOfTheRemovedElements = 0;

        while (!distances.isEmpty ()){
            int indexToRemove = Integer.parseInt ( scan.nextLine ( ) );
            int captured ;

            if (indexToRemove < 0){
                captured = distances.get ( 0 );
                sumOfTheRemovedElements += captured;
                distances.add ( 1, distances.get ( distances.size () - 1 ) );
                distances.remove ( 0 );

            } else if ( indexToRemove > distances.size () - 1 ) {
                captured = distances.get ( distances.size () - 1 );
                sumOfTheRemovedElements += captured;
                distances.remove ( distances.size () - 1 );
                distances.add ( distances.get ( 0 ) );

            }else {
                captured = distances.get ( indexToRemove );
                sumOfTheRemovedElements += captured;
                distances.remove ( indexToRemove );

            }
            for ( int position = 0; position < distances.size (); position++ ) {
                if ( distances.get ( position ) <= captured ){
                    distances.set ( position, distances.get ( position ) + captured );

                }else {
                    distances.set ( position, distances.get ( position ) - captured );
                }
            }
        }

        System.out.println ( sumOfTheRemovedElements );
    }
}