import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main ( String[] args ) {

        Scanner scan = new Scanner ( System.in );

        List <Integer> firstPlayerCards =
                Arrays.stream ( scan.nextLine ().split ( " " ) )
                .map ( Integer::parseInt )
                .collect( Collectors.toList());

        List <Integer> secondPlayerCards =
                Arrays.stream ( scan.nextLine ().split ( " " ) )
                .map ( Integer::parseInt )
                .collect( Collectors.toList());

        while (!firstPlayerCards.isEmpty ( ) && !secondPlayerCards.isEmpty ( )){

            if (firstPlayerCards.get ( 0 ) > secondPlayerCards.get ( 0 )){
                firstPlayerCards.add ( firstPlayerCards.get ( 0 ) );
                firstPlayerCards.remove ( 0 );
                firstPlayerCards.add ( secondPlayerCards.get ( 0 ) );
                secondPlayerCards.remove ( 0 );

            } else if ( secondPlayerCards.get ( 0 ) > firstPlayerCards.get ( 0 ) ) {
                secondPlayerCards.add ( secondPlayerCards.get ( 0 ) );
                secondPlayerCards.remove ( 0 );
                secondPlayerCards.add ( firstPlayerCards.get ( 0 ) );
                firstPlayerCards.remove ( 0 );

            }else{
                firstPlayerCards.remove ( 0 );
                secondPlayerCards.remove ( 0 );
            }
        }
        if( !firstPlayerCards.isEmpty () ){
            int result = sumCards ( firstPlayerCards );
            System.out.println ( "First player wins! Sum: " + result);

        } else if ( !secondPlayerCards.isEmpty () ) {
            int result = sumCards ( secondPlayerCards);
            System.out.println ( "Second player wins! Sum: " + result);
        }
    }
    public static int sumCards (List <Integer> cards){
        int sum = 0;
        for ( int element: cards ) {
            sum += element;
        }
        return sum;
    }
}
