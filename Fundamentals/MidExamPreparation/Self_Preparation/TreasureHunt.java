import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TreasureHunt {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        List<String> itemsInTheCollection =
                Arrays.stream ( scan.nextLine ().split ( "\\|" ) )
                .collect( Collectors.toList());

        String [] commandLine = scan.nextLine ( ).split ( " ");
        while (!commandLine[0].equals ( "Yohoho!" )){
            switch (commandLine [0]){
                case "Loot":
                    for ( int i = 1 ; i < commandLine.length ; i++ ) {
                        if ( !itemsInTheCollection.contains ( commandLine [i] ) ){
                            itemsInTheCollection.add ( 0, commandLine [i] );
                        }
                    }
                    break;
                case "Drop":
                    int indexToDrop = Integer.parseInt ( commandLine [1] );
                    if( indexToDrop >= 0 && indexToDrop < itemsInTheCollection.size ()){
                        itemsInTheCollection.add ( itemsInTheCollection.get ( indexToDrop ) );
                        itemsInTheCollection.remove ( indexToDrop );
                    }
                    break;
                case "Steal":
                    int stolenItems = Integer.parseInt ( commandLine [1] );
                    if (stolenItems > itemsInTheCollection.size () ){
                        stolenItems = itemsInTheCollection.size ();
                    }
                    int startIndex = itemsInTheCollection.size () - stolenItems;
                    while ( startIndex < itemsInTheCollection.size () ) {
                        if (startIndex == itemsInTheCollection.size () - 1){
                            System.out.println ( itemsInTheCollection.get ( startIndex ) );
                            itemsInTheCollection.remove ( startIndex );
                        }else{
                            System.out.print (itemsInTheCollection.get ( startIndex ) + ", ");
                            itemsInTheCollection.remove ( startIndex );
                        }
                    }
                    break;
            }
            commandLine = scan.nextLine ().split ( " " );
        }
        if (itemsInTheCollection.isEmpty ()){
            System.out.println ( "Failed treasure hunt." );
        }else{
            int sumOfAllWordsLength = 0;
            for ( String element: itemsInTheCollection ) {
                sumOfAllWordsLength += element.length ();
            }
            double treasureGain = sumOfAllWordsLength * 1.0 / itemsInTheCollection.size ();
            System.out.printf ( "Average treasure gain: %.2f pirate credits.%n",treasureGain );
        }
    }
}
