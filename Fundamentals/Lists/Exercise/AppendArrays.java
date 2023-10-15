import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppendArrays {
    public static void main ( String[] args ) {

        Scanner scan = new Scanner ( System.in );

        String [] arraysInList = scan.nextLine ().split ( "\\|" ) ;


        List <Integer> extractedNumbers = new ArrayList<> ();

        for ( int i = arraysInList.length - 1 ; i >= 0 ; i--) {

            String [] currentArray = arraysInList [i].split ( " " );

            for ( String character : currentArray ) {

                if ( character.contains ( "0" ) || character.contains ( "1" ) ||
                        character.contains ( "2" ) || character.contains ( "3" ) ||
                        character.contains ( "4" ) || character.contains ( "5" ) ||
                        character.contains ( "6" ) || character.contains ( "7" ) ||
                        character.contains ( "8" ) || character.contains ( "9" ) ) {

                    int num = Integer.parseInt ( character );
                    extractedNumbers.add ( num );
                }
            }
        }
        for ( int element: extractedNumbers ) {
            System.out.print ( element + " " );
        }
    }
}
