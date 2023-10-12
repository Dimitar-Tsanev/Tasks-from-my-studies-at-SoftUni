import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        List<Integer> numbers = Arrays.stream ( scan.nextLine ().split(" ") )
                .map(Integer::parseInt).collect( Collectors.toList());

        String [] command = scan.nextLine ().split( " ");

        while ( !command [0].equals ( "end" )){
            switch (command [0]){
                case "Add":
                    numbers.add ( Integer.parseInt ( command [1] ));
                    break;
                case "Remove":
                    int toRemove = Integer.parseInt ( command [1] );
                    removeContainElement ( numbers,toRemove );
                    break;
                case "RemoveAt":
                    numbers.remove ( Integer.parseInt ( command [1] ) );
                    break;
                case "Insert":
                    numbers.add ( Integer.parseInt ( command [2]),
                            Integer.parseInt ( command [1] ) );
                    break;
            }
            command = scan.nextLine ().split ( " " );
        }
        for ( Integer element : numbers ) {
            System.out.print ( element + " " );
        }
    }
    public static void removeContainElement (List <Integer> list, int toRemove ){
        for ( int i = 0 ; i < list.size () ; i++ ) {
            if (list.get ( i ) == ( toRemove )){
                list.remove ( i );
            }
        }
    }
}
