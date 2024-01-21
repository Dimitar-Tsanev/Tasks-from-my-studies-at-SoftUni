import java.util.*;
import java.util.stream.Collectors;

public class HandsOfCards {
    private static Map <String, Integer> cardsPower = new HashMap<> ( );

    private static Map<Character, Integer> typesPower = new HashMap<> (  );

    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        putPowerOfCards ( );
        putPowerOfTypes ();

        Map<String, Set<String>> playersCards = new LinkedHashMap<> (  );
        Map<String, Integer> playersTotalSumOfCards = new LinkedHashMap<> (  );

        String input = scanner.nextLine ( );

        while (!"JOKER".equals ( input )){
            String name = input.split ( ": " )[0];

            List<String> playerCards = Arrays.stream( input.split ( ": " )[1]
                    .split ( ", " ) )
                    .collect ( Collectors.toList ( ) );

            playersCards.putIfAbsent ( name,new HashSet<> (  ) );
            playersCards.get (name  ).addAll ( playerCards );

            input = scanner.nextLine ();
        }
        calculatePlayerHandOfCards ( playersCards,playersTotalSumOfCards );

        playersTotalSumOfCards.forEach ( (k,v) -> System.out.println ( k + ": " + v ) );

    }
    public static void calculatePlayerHandOfCards(Map<String, Set<String>> playersCards,
                                                 Map<String, Integer> playersTotalSumOfCards){

        //Card total power = cardPower * typesPower;

        for ( Map.Entry<String, Set<String>> player: playersCards.entrySet ()){
            int total = 0;
            for ( String card: player.getValue () ){
                total += ( cardsPower.get ( card.substring ( 0,card.length () - 1 ) )
                        * typesPower.get ( card.charAt ( card.length () - 1 ) ));
            }
            playersTotalSumOfCards.put(player.getKey (),total);
        }
    }
    private static void putPowerOfCards ( ){
        cardsPower.put ( "2", 2);
        cardsPower.put ( "3", 3);
        cardsPower.put ( "4", 4);
        cardsPower.put ( "5", 5);
        cardsPower.put ( "6", 6);
        cardsPower.put ( "7", 7);
        cardsPower.put ( "8", 8);
        cardsPower.put ( "9", 9);
        cardsPower.put ( "10", 10);
        cardsPower.put ( "J", 11);
        cardsPower.put ( "Q", 12);
        cardsPower.put ( "K", 13);
        cardsPower.put ( "A", 14);
    }
    private static void putPowerOfTypes (){
        typesPower.put ( 'S',4 );
        typesPower.put ( 'H',3 );
        typesPower.put ( 'D',2 );
        typesPower.put ( 'C',1 );
    }
}
