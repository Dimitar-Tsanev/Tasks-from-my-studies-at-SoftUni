import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame {
    public static void main ( String[] args ) {
        Scanner scan = new Scanner ( System.in );

        List<String> board =
                Arrays.stream ( scan.nextLine ().split ( " " ) )
                .collect( Collectors.toList());

        String command = scan.nextLine ();
        int movesCounter = 0;

        while (!command.equals ( "end" ) && !board.isEmpty ()){
            movesCounter ++;
            int firstIndex = Integer.parseInt ( command.split ( " " ) [0] );
            int secondIndex = Integer.parseInt ( command.split ( " " ) [1] );

            if (firstIndex != secondIndex &&
                    (firstIndex >= 0 && firstIndex < board.size ()) &&
                    (secondIndex >= 0 && secondIndex < board.size ())){

                if ( board.get ( firstIndex ).equals ( board.get ( secondIndex ) ) ){
                    System.out.printf ( "Congrats! You have found matching elements - %s!%n", board.get ( firstIndex ) );
                    if (firstIndex > secondIndex) {
                        board.remove ( firstIndex );
                        board.remove ( secondIndex );
                    }else {
                        board.remove ( secondIndex );
                        board.remove ( firstIndex );
                    }

                }else{
                    System.out.println ( "Try again!" );
                }
            }else {
                System.out.println ( "Invalid input! Adding additional elements to the board" );
                if (board.size () % 2 == 0 ){
                    board.add ( board.size () /2, "-" + movesCounter + "a" );
                    board.add ( board.size () /2 + 1, "-" + movesCounter + "a" );
                }else{
                    board.add ( board.size () /2 + 1, "-" + movesCounter + "a" );
                    board.add ( board.size () /2 + 1, "-" + movesCounter + "a" );
                }
            }
            command = scan.nextLine ();
        }
        if(board.isEmpty ()){
            System.out.printf ( "You have won in %d turns!%n", movesCounter );
        }else{
            System.out.println ("Sorry you lose :(" );
            System.out.println ( String.join ( " ", board ) );
        }
    }
}
