import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        ArrayDeque <String> currentInGame = new ArrayDeque<> ();

        String[] namesInTheBeginning = scanner.nextLine ().split ( " ");
        int cycles = Integer.parseInt ( scanner.nextLine () );

        for ( String name: namesInTheBeginning ) {
            currentInGame.offer ( name );

        }
        while (currentInGame.size () > 1){
            for ( int i = 1 ; i < cycles ; i++ ) {
                currentInGame.offer (  currentInGame.poll ( ) ) ;

            }
            System.out.println ("Removed " + currentInGame.poll ());

        }
        System.out.println ( "Last is " + currentInGame.poll () );
    }
}
