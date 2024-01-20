import java.util.*;
import java.util.stream.Collectors;

public class VoinaNumberGame {
    private static final Scanner scanner = new Scanner ( System.in );
    public static void main ( String[] args ) {


        Set<Integer> firstPlayer = new LinkedHashSet<> (  );
        Set<Integer> secondPlayer = new LinkedHashSet<> (  );

        getCards ( firstPlayer );
        getCards ( secondPlayer );

        for ( int i = 0 ; i < 50; i++ ) {
            if(firstPlayer.isEmpty () || secondPlayer.isEmpty ()){
                break;
            }
            int firstPlayerNumber = firstPlayer.iterator ().next ();
            firstPlayer.remove ( firstPlayerNumber );

            int secondPlayerNumber = secondPlayer.iterator ().next ();
            secondPlayer.remove ( secondPlayerNumber );

            if(firstPlayerNumber > secondPlayerNumber){
                firstPlayer.add ( firstPlayerNumber );
                firstPlayer.add ( secondPlayerNumber );

            } else if ( firstPlayerNumber < secondPlayerNumber ) {
                secondPlayer.add ( firstPlayerNumber );
                secondPlayer.add ( secondPlayerNumber );

            }
        }
        String wins = firstPlayer.size () > secondPlayer.size ( )? "First player win!":
                firstPlayer.size () < secondPlayer.size (  )? "Second player win!" : "Draw!";

        System.out.println (wins);

    }
    private static void getCards ( Set<Integer> cards){
        List<Integer> numbers = Arrays.stream ( scanner.nextLine ( ).split ( "\\s+" ) )
                .map ( Integer::parseInt )
                .collect ( Collectors.toList ( ) );

        cards.addAll ( numbers );
    }
}
