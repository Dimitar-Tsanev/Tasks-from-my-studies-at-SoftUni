import java.util.*;
import java.util.stream.Collectors;

public class Blacksmith {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner ( System.in );

        Map<Integer, String> craftsmenMaterialNeeded = Map.of (
                70, "Gladius",
                80, "Shamshir",
                90, "Katana",
                110, "Sabre" );

        Map<String, Integer> craftedSwords = new TreeMap<> ( );

        Queue<Integer> steelFractions = Arrays.stream ( scanner.nextLine ( ).split ( "\\s+" ) )
                .map ( Integer::parseInt )
                .collect ( Collectors.toCollection ( ArrayDeque::new ) );

        Deque<Integer> carbonFractions = fillDeque ( scanner );

        while (!steelFractions.isEmpty ( ) && !carbonFractions.isEmpty ( )) {
            int steel = steelFractions.poll ( );
            int carbon = carbonFractions.pop ( );

            if (craftsmenMaterialNeeded.containsKey ( steel + carbon )){
                String swordName = craftsmenMaterialNeeded.get ( steel + carbon );

                craftedSwords.putIfAbsent ( swordName, 0 );
                craftedSwords.put ( swordName, craftedSwords.get ( swordName ) + 1 );

            }else {
                carbonFractions.push ( carbon + 5 );
            }
        }
        printResult(craftedSwords,steelFractions,carbonFractions);

    }

    private static void printResult ( Map<String, Integer> craftedSwords, Queue<Integer> steelFractions, Deque<Integer> carbonFractions ) {

        if (craftedSwords.isEmpty ()){
            System.out.println ( "You did not have enough resources to forge a sword." );

        }else {
            int allCrafted = craftedSwords.values ( ).stream ( ).mapToInt ( i -> i ).sum ( );
            System.out.printf ( "You have forged %d swords.%n", allCrafted );
        }

        System.out.print( "Steel left: ");

        System.out.println ( steelFractions.isEmpty ()?
                "none" :
                steelFractions.toString ().replaceAll ( "[\\[\\]]","" ) );

        System.out.print( "Carbon left: ");

        System.out.println ( carbonFractions.isEmpty ()?
                "none" :
                carbonFractions.toString ().replaceAll ( "[\\[\\]]","" ) );

        if (!craftedSwords.isEmpty ()){
            craftedSwords.forEach ( (k,v) -> System.out.println ( k + ": " +v ) );
        }
    }

    private static Deque<Integer> fillDeque ( Scanner scanner ) {
        Deque<Integer> deque = new ArrayDeque<> ( );

        List<Integer> list = Arrays.stream ( scanner.nextLine ( ).split ( "\\s+" ) )
                .map ( Integer::parseInt )
                .collect ( Collectors.toList ( ) );

        list.forEach ( deque::push );
        return deque;
    }
}