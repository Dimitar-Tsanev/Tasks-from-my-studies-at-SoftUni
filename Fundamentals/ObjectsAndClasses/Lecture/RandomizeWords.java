import java.util.Random;
import java.util.Scanner;

public class RandomizeWords {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );
        String [] words = scan.nextLine ().split ( " " );
        Random rand = new Random ();
        for ( int firstPosition = 0 ; firstPosition < words.length ; firstPosition++ ) {
            int randomPosition  = rand.nextInt ( words.length);
            if ( randomPosition != firstPosition ){
                String swapper = words [firstPosition];
                words [firstPosition] = words [randomPosition];
                words [randomPosition] = swapper;
            }
        }
        System.out.println ( String.join ( System.lineSeparator (), words ) );
    }
}
