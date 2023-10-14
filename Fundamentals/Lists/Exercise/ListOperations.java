import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main ( String[] args ) {

        Scanner scan = new Scanner ( System.in );
        List <Integer> numbers =
                 Arrays.stream ( scan.nextLine ().split ( " " ) )
                .map ( Integer::parseInt )
                .collect( Collectors.toList());

        String [] operations = scan.nextLine ().split ( " " );

        while (!operations [0].equals ( "End" )){
            switch (operations [0]){
                case "Add":
                    int toAdd = Integer.parseInt ( operations [1] );
                    numbers.add ( toAdd );
                    break;

                case "Insert":
                    int toInsert = Integer.parseInt ( operations [1] );
                    int atIndex = Integer.parseInt ( operations [2] );

                    if (atIndex >=0 && atIndex <= numbers.size ()-1){
                        numbers.add ( atIndex,toInsert );

                    }else{
                        System.out.println ( "Invalid index" );

                    }
                    break;

                case "Remove":
                    int indexToRemove = Integer.parseInt ( operations [1] );
                    if (indexToRemove >= 0 && indexToRemove <= numbers.size () - 1){
                        numbers.remove ( indexToRemove );

                    }else{
                        System.out.println ( "Invalid index" );

                    }
                    break;

                case "Shift":
                    int countTimes = Integer.parseInt ( operations [2] );

                    if (operations [1].equals ( "left" )){

                        for ( int i = 0 ; i < countTimes ; i++ ) {
                            numbers.add ( numbers.get ( 0 ) );
                            numbers.remove ( 0 );
                        }

                    } else if ( operations [1].equals ( "right" ) ) {

                        for ( int i = 0 ; i < countTimes ; i++ ) {
                            numbers.add ( 0, numbers.get ( numbers.size () - 1 ) );
                            numbers.remove ( numbers.size () - 1 );
                        }
                    }
                    break;
            }
            operations = scan.nextLine ().split ( " " );
        }
        for ( int element: numbers ) {
            System.out.print ( element + " " );
        }
    }
}
