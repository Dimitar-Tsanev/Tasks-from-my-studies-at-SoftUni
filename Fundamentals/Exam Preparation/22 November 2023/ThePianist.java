import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class ThePianist {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        int initialNumberOfPieces = Integer.parseInt ( scanner.nextLine () );

        LinkedHashMap<String, List<String>> pieces = new LinkedHashMap<> ();

        for ( int i = 1 ; i <= initialNumberOfPieces  ; i++ ) {
            String[] pieceInfo = scanner.nextLine ().split ( "\\|" );

            String pieceName = pieceInfo[0];
            String composer = pieceInfo [1];
            String key = pieceInfo [2];

            addPiece ( pieces,pieceName,composer,key );

        }
        String[] commandline = scanner.nextLine ().split ( "\\|" );

        while (!commandline[0].equals ( "Stop" )){
            String pieceName = commandline[1];

            switch (commandline[0]){
                case "Add":
                    if (pieces.containsKey ( pieceName )){
                        System.out.println ( pieceName + " is already in the collection!");

                    }else {
                        String composer = commandline[2];
                        String key = commandline[3];

                        addPiece ( pieces,pieceName,composer,key );

                        System.out.printf ( "%s by %s in %s added to the collection!%n", pieceName,composer,key );

                    }
                    break;

                case "Remove":
                    if ( !pieces.containsKey ( pieceName ) ){
                        printInvalid (pieceName);

                    }else{
                        pieces.remove ( pieceName );
                        System.out.println ("Successfully removed " + pieceName + "!");

                    }
                    break;

                case "ChangeKey":
                    if(!pieces.containsKey ( pieceName )){
                        printInvalid (pieceName);

                    }else{
                        String pieceNewKey = commandline[2];

                        pieces.get ( pieceName ).remove ( 1 );
                        pieces.get ( pieceName ).add ( pieceNewKey );

                        System.out.printf ( "Changed the key of %s to %s!%n", pieceName,pieceNewKey );

                    }
                    break;

            }
            commandline = scanner.nextLine ().split ( "\\|" );

        }
        pieces.forEach (( k, v ) -> System.out.printf (k + " -> Composer: %s, Key: %s%n",v.get ( 0 ), v.get ( 1 )));

    }
    public static void addPiece (LinkedHashMap<String, List<String>> pieces, String pieceName, String composer, String key){
        if (!pieces.containsKey ( pieceName )){
            pieces.put ( pieceName, new ArrayList<> () );

            pieces.get ( pieceName ).add ( composer );
            pieces.get ( pieceName).add ( key );
        }
    }
    public static void printInvalid (String pieceName){
            System.out.printf ( "Invalid operation! %s does not exist in the collection.%n",pieceName );
    }
}
