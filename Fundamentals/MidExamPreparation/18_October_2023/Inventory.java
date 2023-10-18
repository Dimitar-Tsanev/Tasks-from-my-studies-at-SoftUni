import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );

        List<String> items = Arrays.stream ( scan.nextLine ( ).split ( ", " ) )
                .collect ( Collectors.toList ( ) );

        String[] commandLine = scan.nextLine ( ).split ( " - " );

        while (!commandLine[0].equals ( "Craft!" )) {
            String command = commandLine[0];
            String item = commandLine[1];
            if ( command.equals ( "Collect" ) && !items.contains ( item ) ) {
                items.add ( item );
            } else if ( command.equals ( "Drop" ) && items.contains ( item ) ) {
                items.remove ( item );
            } else if ( command.equals ( "Combine Items" ) ) {
                String[] toCombine = item.split ( ":" );
                item = toCombine[0];
                String secondItem = toCombine[1];
                if (items.contains ( item )){
                    int indexOfTheItem = items.indexOf ( item );
                    items.add ( indexOfTheItem + 1, secondItem );
                }
            } else if ( command.equals ( "Renew" ) && items.contains ( item ) ) {
                items.add ( item );
                items.remove ( item );
            }

            commandLine = scan.nextLine ( ).split ( " - " );
        }
        for ( int i = 0 ; i < items.size () ; i++ ) {
            if (i == items.size () - 1){
                System.out.println ( items.get ( i ) );
                break;
            }
            System.out.print ( items.get ( i ) + ", ");
        }
    }
}